package com.yurdan.bankCardService.model.entity;

import com.yurdan.bankCardService.model.enums.CardStatus;
import com.yurdan.bankCardService.model.enums.converter.CardStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String cardNumber;// Далее сделать чтобы он был зашифрованным

    @Column(nullable = false)
    @Timestamp // ?
    private LocalDateTime expirationDate;

    @Convert(converter = CardStatusConverter.class)
    private CardStatus cardStatus;

    private Long ownerId;
    private String currency;
    private BigDecimal balance;
// UUID uuid;
}
