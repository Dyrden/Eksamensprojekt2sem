package com.example.eksamensprojekt_2sem.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class RapportRepository {

    @Value("${JBDCUrl}")
    private String db_URL;

    @Value("${JBDCUsername}")
    private String uid;

    @Value("${JDBCPassword}")
    private String pass;

}
