package com.yurdan.bankCardService.repository;

import com.yurdan.bankCardService.model.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    // Дополнительные методы поиска можно добавить здесь
}
