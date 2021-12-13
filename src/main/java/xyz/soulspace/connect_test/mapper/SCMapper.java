package xyz.soulspace.connect_test.mapper;

import xyz.soulspace.connect_test.pojo.SelectClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SCMapper {
    void insertSC(SelectClass selectClass);

    List<SelectClass> selectSC(Map<String, Object> map);

    void deleteSC(Map<String, Object> map);

    void updateSC(Map<String, Object> map);
}
