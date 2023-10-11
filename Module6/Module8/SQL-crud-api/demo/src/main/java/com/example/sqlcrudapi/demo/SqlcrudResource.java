package com.example.sqlcrudapi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SqlcrudResource {
    private SqlRepository sqlRepository;

    public SqlcrudResource(SqlRepository sqlRepository) {
        this.sqlRepository = sqlRepository;
    }

    @GetMapping("/sql-crud-api/users")
    public List<Map<String, Object>> getUsers(){
        return sqlRepository.selectUsers();
    }
}
