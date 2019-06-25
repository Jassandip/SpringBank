package com.springbank.services;

import com.springbank.beans.Account;
import com.springbank.beans.Login;

public interface SignupServices {
 
    boolean Account(Account account);
    boolean Login(Login login);
}