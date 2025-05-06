package com.yurdan.bankCardService.service;

import com.yurdan.bankCardService.model.entity.BankAccount;
import com.yurdan.bankCardService.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardService {
    @Autowired
    private  BankAccountRepository bankAccountRepository;

    public  List<BankAccount> getAllCards() {

        return bankAccountRepository.findAll();
    }

    public  BankAccount createCard(BankAccount bankAccount) {
        // Логика создания карты (шифрование номера и т.д.)
        return bankAccountRepository.save(bankAccount);
    }

    // Другие методы для блокировки, активации и удаления карт

}
