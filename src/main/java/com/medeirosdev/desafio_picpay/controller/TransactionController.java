package com.medeirosdev.desafio_picpay.controller;

import com.medeirosdev.desafio_picpay.dtos.TransactionDTO;
import com.medeirosdev.desafio_picpay.service.TransactionService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> transaction(@RequestBody TransactionDTO dto){

        transactionService.transaction(dto);

        return ResponseEntity.status(201).build();

    }

}
