package com.medeirosdev.desafio_picpay.repository;

import com.medeirosdev.desafio_picpay.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
