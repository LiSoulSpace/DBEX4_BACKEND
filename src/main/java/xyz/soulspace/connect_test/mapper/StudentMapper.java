package xyz.soulspace.connect_test.mapper;


import xyz.soulspace.connect_test.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {
    void insertStudent(Student student);

    List<Student> getStudentsByCAN(Map<String, Object> map);

    void updateStudent(Map<String, Object> map);

    void deleteStudent(Map<String, Object> map) throws DataAccessException;
}
