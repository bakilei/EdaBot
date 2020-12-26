package com.tufypace.yaedabot.model.balance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.order.Time;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceHistory {
    @JsonProperty("balance")
    public int balance;
    @JsonProperty("comment")
    public String comment;
    @JsonProperty("dateTime")
    public Time dateTime;
    @JsonProperty("sum")
    public int sum;

    public BalanceHistory(int balance, String comment, Time dateTime, int sum) {
        this.balance = balance;
        this.comment = comment;
        this.dateTime = dateTime;
        this.sum = sum;
    }

    public BalanceHistory() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceHistory that = (BalanceHistory) o;
        return balance == that.balance &&
                sum == that.sum &&
                comment.equals(that.comment) &&
                dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, comment, dateTime, sum);
    }

    @Override
    public String toString() {
        return "BalanceHistory{" +
                "balance=" + balance +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                ", sum=" + sum +
                '}';
    }
}
