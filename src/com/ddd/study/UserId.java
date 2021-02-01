package com.ddd.study;

public class UserId {

    private final String value;

    public UserId(final String value) {

        if (value == null) throw new IllegalArgumentException("値が設定されていません。");

        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
