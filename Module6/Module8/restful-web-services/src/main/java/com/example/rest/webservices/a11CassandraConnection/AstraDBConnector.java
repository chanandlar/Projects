package com.example.rest.webservices.a11CassandraConnection;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.nio.file.Paths;

import java.util.Iterator;

public class AstraDBConnector {
    public static void main(String[] args){
        CqlSession session=CqlSession.builder().
                withCloudSecureConnectBundle(Paths.get("/home/sakhan/Downloads/secure-connect-sampledb.zip"))
                .withAuthCredentials("OxeTjRpqfvhXQYuNUtOcmwIk","NUtOcmwIk:64b6c7997245295cd16ee4885eaf1dd23dc7ad5e9e9deab1a7900ac16669fbde")
                .build();

        ResultSet rs= (ResultSet) session.execute("select * from firstkeyspace.books_by_author");
        printResult(rs);

    }

    private static void printResult(ResultSet rs) {
        Iterator<Row> i=rs.iterator();
        while (i.hasNext()){
            Row row= (Row) i.next();
            System.out.print(row.getString("author_name")+
                    " | "
                    +row.getInt("publish_year")
                    +" | "
                    +row.getFloat("rating"));
            System.out.println();
        }
    }
}
