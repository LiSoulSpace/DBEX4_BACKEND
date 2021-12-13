package xyz.soulspace.connect_test.service;

import xyz.soulspace.connect_test.mapper.ClassMapper;
import xyz.soulspace.connect_test.pojo.Class;
import xyz.soulspace.connect_test.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class ClassService {
    private ClassMapper classMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassService.class);

    @Autowired
    public void setClassMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    public Result<?> getClass(Class class_t) {
        HashMap<String, Object> map = new HashMap<>();
        if (class_t.getCno() > 0) {
            map.put("cno", class_t.getCno());
        }else new Result<>(HttpStatus.FORBIDDEN, "错误的课程号！");
        if (!Objects.equals(class_t.getCname(), "")) map.put("cname", class_t.getCname());
        try {
            List<Class> classes = classMapper.selectClasses(map);
            return new Result<>(HttpStatus.OK, classes);
        }catch (Exception e){
            LOGGER.error(e.toString());
            return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Result<?> addClass(Class class_t) {
        try {
            LOGGER.warn(String.valueOf(class_t));
            if (class_t.getCno() <= 0)
                return new Result<>(HttpStatus.FORBIDDEN, "课程号必须大于0！");
            classMapper.insertClass(class_t);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new Result<>(HttpStatus.OK, "OK");
    }

    public Result<?> deleteClass(Class class_t) throws DataAccessException {
        HashMap<String, Object> map = new HashMap<>();
        if (class_t.getCno() > 0) {
            map.put("cno", class_t.getCno());
        } else return new Result<>(HttpStatus.FORBIDDEN, "No class found!");
        try {
            classMapper.deleteClass(map);
            return new Result<>(HttpStatus.OK, "OK");
        }catch (Exception e){
            LOGGER.error(e.toString());
            return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong");
        }
    }

    public Result<?> updateClass(Class class_t) {
        HashMap<String, Object> map = new HashMap<>();
        if (class_t.getCno() > 0) {
            map.put("cno", class_t.getCno());
        }else return new Result<>(HttpStatus.FORBIDDEN, "错误的课程号!");
        if (class_t.getCcredit() > 0) {
            map.put("ccredit", class_t.getCcredit());
        }else return new Result<>(HttpStatus.FORBIDDEN, "错误的学分！");
        if (class_t.getCpno() > 0) {
            map.put("cpno", class_t.getCpno());
        }else return new Result<>(HttpStatus.FORBIDDEN, "错误的前序课程号！");
        if (!Objects.equals(class_t.getCname(), "") && !Objects.equals(class_t.getCname(), null))
            map.put("cname", class_t.getCname());
        try {
            classMapper.updateClass(map);
            return new Result<>(HttpStatus.OK, "OK");
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
