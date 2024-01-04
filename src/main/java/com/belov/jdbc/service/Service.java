package com.belov.jdbc.service;

import com.belov.jdbc.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}