package com.example.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/addUserByJdbc")
    public String addUserByJdbc() {
        String sql = "insert into mybatis.user(id, name, pwd) values (5,'aiwen','123456')";
        jdbcTemplate.update(sql);
        return "addUserByJdbc-OK";
    }
}
