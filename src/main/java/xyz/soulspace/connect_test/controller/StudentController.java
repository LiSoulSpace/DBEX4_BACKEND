package xyz.soulspace.connect_test.controller;

import xyz.soulspace.connect_test.pojo.Student;
import xyz.soulspace.connect_test.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    private StudentService studentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/api/queryStudents")
    @ResponseBody
    public ResponseEntity<?> queryStudentListP(@RequestBody Student student) {
        List<Student> studentList = studentService.getStudent(student);
        LOGGER.info(studentList.toString());
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/queryStudents")
    @ResponseBody
    public List<Student> queryStudentList(@RequestBody Student student) {
        List<Student> studentList = studentService.getStudent(student);
        return studentList;
    }

    @PostMapping("/api/addStudent")
    @ResponseBody
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/api/deleteStudent")
    @ResponseBody
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
        try {
            boolean t = studentService.deleteStudent(student);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/api/updateStudent")
    @ResponseBody
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        LOGGER.warn(String.valueOf(student));
        if (studentService.updateStudent(student)) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
