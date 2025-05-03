package com.yurdan.bankCardManagementSystem.model.entity;

import com.yurdan.bankCardManagementSystem.model.enums.CardStatus;
import com.yurdan.bankCardManagementSystem.model.enums.converter.RefundStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String cardNumber;// Далее сделать чтобы он был зашифрованным

    @Column(nullable = false)
    private String expirationDate;

    @Convert(converter = RefundStatusConverter.class)
    private CardStatus cardStatus;

    private Long ownerId;
    private String currency;
    private BigDecimal balance;

}
