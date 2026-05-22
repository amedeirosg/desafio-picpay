package com.medeirosdev.desafio_picpay.service;


import com.medeirosdev.desafio_picpay.dtos.TransactionDTO;
import com.medeirosdev.desafio_picpay.entities.Transaction;
import com.medeirosdev.desafio_picpay.entities.User;
import com.medeirosdev.desafio_picpay.enums.UserType;
import com.medeirosdev.desafio_picpay.repository.TransactionRepository;
import com.medeirosdev.desafio_picpay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public TransactionDTO transaction(TransactionDTO transaction){

        User sender = userService.findUserByDocument(transaction.getPayer()).orElseThrow(() -> new RuntimeException("Sender user not found!"));
        User receiver = userService.findUserByDocument(transaction.getPayee()).orElseThrow(()-> new RuntimeException("Receiver user not found!"));

        if (sender.getUserType() == UserType.MERCHANT){
            throw new RuntimeException("Usuário lojista não pode efetuar transferencias");
        }

        if (sender.getBalance().compareTo(transaction.getValue()) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }

        sender.withdraw(transaction.getValue());
        receiver.deposit(transaction.getValue());

        userService.save(sender);
        userService.save(receiver);

        Transaction transf = new Transaction(transaction.getValue(), sender, receiver, LocalDateTime.now());

        transactionRepository.save(transf);

        return toDTO(transf);

    }

    public TransactionDTO toDTO(Transaction transaction){

        return new TransactionDTO(transaction.getAmount(),transaction.getSender().getDocument(), transaction.getReceiver().getDocument());

    }

}
