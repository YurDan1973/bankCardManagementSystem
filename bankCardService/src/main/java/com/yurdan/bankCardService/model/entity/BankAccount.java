package com.yurdan.bankCardService.model.entity;

import com.yurdan.bankCardService.model.enums.CardStatus;
import com.yurdan.bankCardService.model.enums.converter.CardStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {

    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;// Далее сделать чтобы он был зашифрованным

    @Column(name = "expiration_date", nullable = false)
    @Timestamp // ?
    private LocalDateTime expirationDate;

    @Column(name = "card_status", nullable = false)
    @Convert(converter = CardStatusConverter.class)
    private CardStatus cardStatus;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
// UUID uuid;
}
