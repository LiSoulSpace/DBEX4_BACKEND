package xyz.soulspace.connect_test.mapper;

import xyz.soulspace.connect_test.pojo.Class;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ClassMapper {
    void insertClass(Class cclass);

    List<Class> selectClasses(Map<String, Object> map);

    void deleteClass(Map<String, Object> map);

    void updateClass(Map<String, Object> map);
}
