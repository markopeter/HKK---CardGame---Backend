package com.cardgameproject.cardgame.enums;

import lombok.Getter;

@Getter
public enum stateType {
    ACTIVE("A"), PASSIVE("P"), DEAD("D");
    private String code;

    stateType(String code) {
        this.code = code;
    }
}
