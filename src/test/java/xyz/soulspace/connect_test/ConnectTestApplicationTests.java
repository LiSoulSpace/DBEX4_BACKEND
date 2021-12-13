package xyz.soulspace.connect_test;

import xyz.soulspace.connect_test.pojo.Student;
import xyz.soulspace.connect_test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


@SpringBootTest
class ConnectTestApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() throws SQLException {
        List<Student> student = studentService.getStudent(new Student());
        System.out.println("student List : " + student);
    }

}
