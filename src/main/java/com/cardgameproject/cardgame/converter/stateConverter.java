package com.cardgameproject.cardgame.converter;

import com.cardgameproject.cardgame.enums.monsterStateType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class stateConverter implements AttributeConverter<monsterStateType, String> {
    @Override
    public String convertToDatabaseColumn(monsterStateType stateType) {
        if (stateType == null) {
            return null;
        }
        return stateType.getCode();
    }

    @Override
    public monsterStateType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(monsterStateType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
