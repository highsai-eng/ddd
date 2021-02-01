package com.ddd.study;

import java.math.BigDecimal;

/**
 * 通貨
 */
public final class Money {

    /** 設定可能な最大の通貨量 */
    private static final int MAX_AMOUNT = 999999;

    /** 通貨量 */
    private final BigDecimal amount;

    /** 通貨単位 */
    private final String currency;

    /**
     * コンストラクタ
     * @param amount 通貨量
     * @param currency 通貨単位
     */
    public Money(final BigDecimal amount, final String currency) {

        if (amount == null) throw new IllegalArgumentException("通貨量が設定されていません。");
        if (currency == null) throw new IllegalArgumentException("通貨単位が設定されていません。");
        if (amount.compareTo(new BigDecimal(MAX_AMOUNT)) > 0) throw new IllegalArgumentException("100万未満である必要があります。");


        this.amount = amount;
        this.currency = currency;
    }

    /**
     * 通貨を加算する
     * @param arg 加算対象の通貨
     * @return 加算後の通貨
     */
    public Money add(Money arg) {

        if (arg == null) throw new IllegalArgumentException("通貨が設定されていません。");
        if (!this.currency.equals(arg.currency)) throw new IllegalArgumentException("通貨単位が異なります。");

        return new Money(this.amount.add(arg.amount), this.currency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (!amount.equals(money.amount)) return false;
        return currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }
}
