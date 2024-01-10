package com.belov.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

//@Repository
public class ProductRepository {

    private String searchByName;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(String searchByName) {
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