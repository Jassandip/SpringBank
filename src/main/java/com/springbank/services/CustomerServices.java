package com.springbank.services;

import com.springbank.beans.SendMoney;

public interface CustomerServices{
 
    boolean sendMoney(String id,SendMoney sm);

}

