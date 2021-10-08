package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void loadData() {
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

        // throw exception if student with given id is not found, throw our custom object exception
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found " + studentId);
        }
        Student student = theStudents.get(studentId);
        return student;
    }

    // this method will handle exception for RestController because of @ExceptionHandler Annotation
    // we are using ResponseEntity because it is a wrapper over httpResponse and it gives us more control
    // to specify the status code, http header and response body
    // this exception handler can catch StudentNotFoundExceptions
    // ===> move both methods with @ExceptionHandler annotation to another class so these are available globally
    // currently they are specific to this controller only
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
//
//        // create StudentErrorResponse
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//        errorResponse.setErrorMessage(ex.getMessage());
//        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        // return responseEntity
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    // add another exception handler to handle any type of exception being thrown, not handling a specific one
//    // so this will send a json response instead of the Exception html generic Page
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleAnyTypeOfException(Exception exception) {
//
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//        errorResponse.setErrorMessage(exception.getMessage());
//        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//
//    }
}
