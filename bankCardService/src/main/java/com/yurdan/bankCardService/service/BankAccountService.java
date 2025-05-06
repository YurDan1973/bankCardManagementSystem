package com.yurdan.bankCardService.service;

import com.yurdan.bankCardService.model.entity.BankAccount;
import com.yurdan.bankCardService.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private  BankAccountRepository bankAccountRepository;

    public  List<BankAccount> getAllCards() {
        return bankAccountRepository.findAll();
    }

    public  BankAccount createCard(BankAccount card) {
        // Логика создания карты (шифрование номера и т.д.)
        return bankAccountRepository.save(card);
    }

    // Другие методы для блокировки, активации и удаления карт

}
