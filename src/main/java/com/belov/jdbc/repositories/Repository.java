package com.belov.jdbc.repositories;

import com.belov.jdbc.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

//@org.springframework.stereotype.Repository
public class Repository {

    private String searchByName;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Repository(String searchByName) {
        this.searchByName = searchByName;
    }

    public String getProductName(String name) {
        List<String> orderList = jdbcTemplate.query(
                searchByName,
                (rs, num) -> new String(rs.getString("product_name")),
                name);
        return orderList.stream().collect(Collectors.joining());
    }
}