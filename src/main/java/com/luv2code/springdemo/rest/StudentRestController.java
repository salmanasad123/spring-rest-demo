package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")  // base request mapping
public class StudentRestController {

    private List<Student> theStudents;

    // use @Post construct to load the data and this is called only once when this given bean is constructed
    //
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        // hardcoding for now, we can use DB here as well
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("Mary", "Public");
        Student student3 = new Student("Susan", "John");

        theStudents.add(student1);
        theStudents.add(student2);
        theStudents.add(student3);

    }

    // define an endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {

        // jackson will convert POJO tp Json behind the scenes when we send the response to our rest client
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getSingleStudent(@PathVariable int studentId) {
        
        Student student = theStudents.get(studentId);
        return student;
    }
}
