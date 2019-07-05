package com.springbank.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SendMoney{
    String from;
    String to;
    BigDecimal amount;
    Timestamp time;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public SendMoney(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "SendMoney [amount=" + amount + ", from=" + from + ", time=" + time + ", to=" + to + "]";
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}