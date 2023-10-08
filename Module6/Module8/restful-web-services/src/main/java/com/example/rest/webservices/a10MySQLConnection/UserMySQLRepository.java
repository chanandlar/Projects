package com.example.rest.webservices.a10MySQLConnection;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMySQLRepository extends JpaRepository<User,Integer> {
}
