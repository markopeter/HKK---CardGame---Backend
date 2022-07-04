package com.cardgameproject.cardgame.converter;

import com.cardgameproject.cardgame.enums.stateType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class stateConverter implements AttributeConverter<stateType, String> {
    @Override
    public String convertToDatabaseColumn(stateType stateType) {
        if (stateType == null) {
            return null;
        }
        return stateType.getCode();
    }

    @Override
    public stateType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(stateType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
