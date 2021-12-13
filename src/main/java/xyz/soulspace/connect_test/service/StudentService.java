package xyz.soulspace.connect_test.service;

import xyz.soulspace.connect_test.mapper.StudentMapper;
import xyz.soulspace.connect_test.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private StudentMapper studentMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getStudent(Student student) {
        HashMap<String, Object> map = new HashMap<>();
        if (student.getSclass() > 0) map.put("sclass", student.getSclass());
        if (student.getSno() > 0) map.put("sno", student.getSno());
        if (!Objects.equals(student.getSname(), "")) map.put("sname", student.getSname());
        System.out.println(map);
        List<Student> studentsByCAN = studentMapper.getStudentsByCAN(map);
        System.out.println("studentsByCAN : " + studentsByCAN);
        return studentsByCAN;
    }

    public boolean addStudent(Student student) {
        if (student.getSno() <= 0 || student.getSclass() <= 0 || student.getSname().equals("")) {
            return false;
        }
        try {
            studentMapper.insertStudent(student);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteStudent(Student student) throws DataAccessException {
        HashMap<String, Object> map = new HashMap<>();
        if (student.getSclass() != 0) {
            map.put("sclass", student.getSclass());
        } else return false;
        if (student.getSno() != 0) {
            map.put("sno", student.getSno());
        } else return false;
        studentMapper.deleteStudent(map);
        return true;
    }

    public boolean updateStudent(Student student) {
        HashMap<String, Object> map = new HashMap<>();
        if (student.getSclass() > 0) map.put("sclass", student.getSclass());
        else return false;
        if (student.getSno() > 0) map.put("sno", student.getSno());
        else return false;
        if (student.getSage() != 0) map.put("sage", student.getSage());
        if (!Objects.equals(student.getSdept(), "") && !Objects.equals(student.getSdept(), null))
            map.put("Sdept", student.getSdept());
        if (!Objects.equals(student.getSsex(), "")) map.put("ssex", student.getSsex());
        if (!Objects.equals(student.getSname(), "")) {
            map.put("sname", student.getSname());
        } else return false;
        try {
            studentMapper.updateStudent(map);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return false;
        }
        return true;
    }

}
