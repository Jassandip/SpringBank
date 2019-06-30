package com.springbank.beans;

import java.sql.Timestamp;

public class SendMoney{
    String id;
    Integer amount;
    Timestamp time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SendMoney [amount=" + amount + ", id=" + id + ", time=" + time + "]";
    }

    public SendMoney(String id, Integer amount) {
        this.id = id;
        this.amount = amount;
        this.time = new Timestamp(System.currentTimeMillis());
    }

}