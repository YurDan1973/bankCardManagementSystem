package com.yurdan.bankCardManagementSystem.model.enums;

public enum CardStatus {
    ACTIVE,
    BLOCKED,
    EXPIRED;

    public static CardStatus fromString(String status) {
        for (CardStatus cardStatus : CardStatus.values()) {
            if (cardStatus.toString().equalsIgnoreCase(status)) {
                return cardStatus;
            }
        }
        throw new IllegalArgumentException("CardStatus: " + status);
    }

}
