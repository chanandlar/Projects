package com.example.sqlcrudapi.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    @Value("${query.selectUsers}")
    private String selectUsersQuery;

    public String getSelectUsersQuery() {
        return selectUsersQuery;
    }

}
