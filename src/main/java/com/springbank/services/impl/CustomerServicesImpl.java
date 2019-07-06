package com.springbank.services.impl;

import java.sql.Types;

import com.springbank.beans.SendMoney;
import com.springbank.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean sendMoney(SendMoney sm) {
        Object[] parameters={sm.getFrom(),sm.getTo(),sm.getAmount(),sm.getTime()};
        int[] types={Types.INTEGER,Types.INTEGER,Types.DECIMAL,Types.TIMESTAMP};
        jdbcTemplate.update("insert into transactions(`from`,`to`,`amount`,`time`) values(?,?,?,?)",parameters,types);
        return true;

    }
}