package com.belov.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private String searchByName;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public ProductRepository(String searchByName) {
//        this.searchByName = searchByName;
//    }

    public ProductRepository() {
        try (InputStream is = new ClassPathResource("search_by_name.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            this.searchByName = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        List<String> orderList = jdbcTemplate.query(
                searchByName,
                (rs, num) -> new String(rs.getString("product_name")),
                name);
        return orderList.stream().collect(Collectors.joining());
    }
}