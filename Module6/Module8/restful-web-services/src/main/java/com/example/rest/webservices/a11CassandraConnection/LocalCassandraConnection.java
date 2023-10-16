package com.example.rest.webservices.a11CassandraConnection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

import java.util.Iterator;

public class LocalCassandraConnection {
    public static void main(String[] args){
        Cluster cluster=Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session=cluster.connect("test_keyspace");

        ResultSet rs=session.execute("select * from employee_by_id");
        printResult(rs);
    }

    private static void printResult(ResultSet rs) {
        Iterator<Row> i=rs.iterator();
        while (i.hasNext()){
            Row row= (Row) i.next();
            System.out.print(row.getString("name")+
                    " | "
                    +row.getInt("id")
                    +" | "
                    +row.getString("position"));
            System.out.println();
        }
    }
}
