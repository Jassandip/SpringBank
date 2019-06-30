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

    public boolean sendMoney(String id, SendMoney sm) {
        Object[] parameters={id,sm.getId(),sm.getAmount(),sm.getTime()};
        int[] types={Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.TIMESTAMP};
        jdbcTemplate.update("insert into transactions(`from`,`to`,`amount`,`time`) values(?,?,?,?)",parameters,types);
        // System.out.println("INSERT INTO transactions (`from`,`to`,`amount`,`time`) VALUES(" + id + "," + sm.getId() + "," + sm.getAmount() + ","
        //         + sm.getTime() + ");");
        // jdbcTemplate.update("INSERT INTO transactions (`from`,`to`,`amount`,`time`) VALUES('" + id + "','" + sm.getId() + "'," + sm.getAmount() + ","
        //         + sm.getTime() + ");");
        return true;

    }
}