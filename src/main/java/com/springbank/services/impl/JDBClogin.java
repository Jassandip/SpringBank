package com.springbank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBClogin {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String authenticate(String[] idAndString){
    String sql = "SELECT TYPE FROM login WHERE id = ? AND password = ?;";
    String type = (String) jdbcTemplate.queryForObject(sql, new Object[] { idAndString[0],idAndString[1] }, String.class);
    return type;
    }
}