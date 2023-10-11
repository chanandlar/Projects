package com.example.sqlcrudapi.demo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SqlRepository {
    private JdbcTemplate jdbcTemplate;
    private QueryService queryService;

    public SqlRepository(JdbcTemplate jdbcTemplate, QueryService queryService) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryService = queryService;
    }

    public List<Map<String, Object>> selectUsers() {
        String sql = queryService.getSelectUsersQuery();
        return jdbcTemplate.queryForList(sql);
    }
}
