package com.yurdan.bankCardService.controller.rest;

import com.yurdan.bankCardService.model.entity.BankAccount;
import com.yurdan.bankCardService.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllCards() {
        return ResponseEntity.ok(bankCardService.getAllCards());
    }

    @PostMapping
    public ResponseEntity<BankAccount> createCard(@RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(bankCardService.createCard(bankAccount));
    }

    // Другие эндпоинты для блокировки, активации и удаления карт

}
