package com.wealthswaysoft.agencybankingapp.repository;

import com.wealthswaysoft.agencybankingapp.entity.Transaction;
//import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
