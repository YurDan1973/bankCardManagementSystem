package com.yurdan.bankCardService.model.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.yurdan.bankCardService.model.enums.CardStatus;

@Converter(autoApply = true)
public class CardStatusConverter implements AttributeConverter<CardStatus, String> {

    @Override
    public String convertToDatabaseColumn(CardStatus attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public CardStatus convertToEntityAttribute(String dbData) {
        return dbData == null ? null : CardStatus.fromString(dbData);
    }

}

