package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"Learn-AWS","Shoeb"),
                new Course(2,"Learn-Devops","Shoeb"),
                new Course(3,"Learn Azure","Shoeb"),
                new Course(4,"DSA","Shoeb")
        );
    }
}
