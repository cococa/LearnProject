package com.cocoa;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

public class Money implements Serializable, Comparable<Money> {
    private static final long serialVersionUID = -1459240821831878390L;
    private static final long hundred = 100L;
    private long milliAmount;
    private long amount;

    public Money() {
    }

    public Money(long cent) {
        this.milliAmount = convertCentToMilli(cent);
        this.amount = this.milliAmount / 100L;
    }

    public static Money ofMilli(long milli) {
        Money money = new Money();
        money.setMilliAmount(milli);
        return money;
    }

    public static Money ofCent(long cent) {
        Money money = new Money();
        money.setMilliAmount(convertCentToMilli(cent));
        return money;
    }

    public static Money ofYuan(double yuan) {
        Money money = new Money();
        money.setMilliAmount(convertYuanToMilli(yuan));
        return money;
    }

    public long getMilli() {
        return this.getMilliAmount();
    }

    public long getCent() {
        long tmpMilliAmount = this.getMilliAmount();
        if (tmpMilliAmount > 0L) {
            return (tmpMilliAmount + 50L) / 100L;
        } else {
            return tmpMilliAmount < 0L ? (tmpMilliAmount - 50L) / 100L : tmpMilliAmount / 100L;
        }
    }

    public double getYuan() {
        return BigDecimal.valueOf(this.getMilliAmount()).movePointLeft(4).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void setMilli(long milli) {
        this.setMilliAmount(milli);
    }

    public void setCent(long cent) {
        this.setMilliAmount(cent * 100L);
    }

    public void setYuan(double yuan) {
        this.setMilliAmount(convertYuanToMilli(yuan));
    }

    public static Money total(Money... monies) {
        if (monies.length == 0) {
            throw new IllegalArgumentException("Money array must not be empty");
        } else {
            return total((Iterable) Lists.newArrayList(monies));
        }
    }

    public static Money total(Iterable<? extends Money> monies) {
        Preconditions.checkNotNull(monies, "Money iterator must not be null");
        Iterator<? extends Money> it = monies.iterator();
        if (!it.hasNext()) {
            throw new IllegalArgumentException("Money iterator must not be empty");
        } else {
            Money total = (Money)it.next();
            Preconditions.checkNotNull(total, "Money iterator must not contain null entries");

            while(it.hasNext()) {
                total = total.plus((Money)it.next());
            }

            return total;
        }
    }

    public Money plus(Money money) {
        Preconditions.checkNotNull(money, "money must not be null");
        return this.plusCent(money.getCent());
    }

    public Money plusMilli(long milli) {
        this.setMilliAmount(this.milliAmount + milli);
        return this;
    }

    public Money plusCent(long cent) {
        this.setMilliAmount(this.milliAmount + convertCentToMilli(cent));
        return this;
    }

    public Money plusYuan(double yuan) {
        if (yuan == 0.0D) {
            return this;
        } else {
            this.setMilliAmount(this.milliAmount + convertYuanToMilli(yuan));
            return this;
        }
    }

    public Money minus(Money money) {
        Preconditions.checkNotNull(money, "money must not be null");
        return this.minusCent(money.getCent());
    }

    public Money minusMilli(long milli) {
        this.setMilliAmount(this.milliAmount - milli);
        return this;
    }

    public Money minusCent(long cent) {
        this.setMilliAmount(this.milliAmount - convertCentToMilli(cent));
        return this;
    }

    public Money minusYuan(double yuan) {
        if (yuan == 0.0D) {
            return this;
        } else {
            this.setMilliAmount(this.milliAmount - convertYuanToMilli(yuan));
            return this;
        }
    }

    public Money multipliedBy(double valueToMultiplyBy) {
        if (valueToMultiplyBy == 1.0D) {
            return this;
        } else {
            double newAmountCent = (double)this.getMilliAmount() * valueToMultiplyBy;
            this.setMilliAmount(BigDecimal.valueOf(newAmountCent).setScale(0, RoundingMode.HALF_UP).longValue());
            return this;
        }
    }

    public Money multipliedBy(long valueToMultiplyBy) {
        if (valueToMultiplyBy == 1L) {
            return this;
        } else {
            this.setMilliAmount(this.getMilliAmount() * valueToMultiplyBy);
            return this;
        }
    }

    public boolean isNegative() {
        return this.getMilliAmount() < 0L;
    }

    public boolean isNegativeOrZero() {
        return this.getMilliAmount() <= 0L;
    }

    public boolean isEqual(Money other) {
        return this.compareTo(other) == 0;
    }

    public boolean isGreaterThan(Money other) {
        return this.compareTo(other) > 0;
    }

    public boolean isLessThan(Money other) {
        return this.compareTo(other) < 0;
    }

    public static Money zero() {
        return ofCent(0L);
    }

    public static Long convertYuanToCent(double yuan) {
        return BigDecimal.valueOf(yuan).movePointRight(2).setScale(0, RoundingMode.HALF_UP).longValue();
    }

    public static Long convertYuanToMilli(double yuan) {
        return BigDecimal.valueOf(yuan).movePointRight(4).setScale(0, RoundingMode.HALF_UP).longValue();
    }

    public static double convertCentToYuan(long cent) {
        return (double)cent / 100.0D;
    }

    public static long convertCentToMilli(long cent) {
        return cent * 100L;
    }

    public long getMilliAmount() {
        return this.milliAmount;
    }

    public void setMilliAmount(long milliAmount) {
        this.amount = milliAmount / 100L;
        this.milliAmount = milliAmount;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.milliAmount = amount * 100L;
        this.amount = amount;
    }

    public int hashCode() {
        return Longs.hashCode(this.milliAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Money) {
            Money otherMoney = (Money)other;
            return this.milliAmount == otherMoney.milliAmount;
        } else {
            return false;
        }
    }

    public int compareTo(Money otherMoney) {
        return otherMoney == null ? 1 : Longs.compare(this.milliAmount, otherMoney.milliAmount);
    }

    public String toString() {
        return this.getMilliAmount() + " milli";
    }
}
