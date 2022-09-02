package com.cardgameproject.cardgame.enums;

import lombok.Getter;

@Getter
public enum monsterStateType {
    ACTIVE("A"), PASSIVE("P"), DEAD("D");
    private String code;

    monsterStateType(String code) {
        this.code = code;
    }
}
