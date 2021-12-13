package xyz.soulspace.connect_test.service;

import xyz.soulspace.connect_test.mapper.SCMapper;
import xyz.soulspace.connect_test.pojo.SelectClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SCService {
    private SCMapper scMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(SCService.class);

    @Autowired
    public void setScMapper(SCMapper scMapper) {
        this.scMapper = scMapper;
    }

    public List<SelectClass> getSC(SelectClass selectClass) throws DataAccessException {
        HashMap<String, Object> map = new HashMap<>();
        if (selectClass.getSclass() > 0) map.put("sclass", selectClass.getSclass());
        if (selectClass.getSno() > 0) map.put("sno", selectClass.getSno());
        if (selectClass.getCno() > 0) map.put("cno", selectClass.getCno());
        if (selectClass.getGrade() > 0) map.put("grade", selectClass.getGrade());
        List<SelectClass> selectClassList = scMapper.selectSC(map);
        return selectClassList;
    }

    public boolean deleteSC(SelectClass selectClass) throws DataAccessException {
        HashMap<String, Object> map = new HashMap<>();
        if (selectClass.getSno() > 0) {
            map.put("sno", selectClass.getSno());
        } else return false;
        if (selectClass.getSclass() > 0) {
            map.put("sclass", selectClass.getSclass());
        } else return false;
        if (selectClass.getCno() > 0) {
            map.put("cno", selectClass.getCno());
        } else return false;
        scMapper.deleteSC(map);
        return true;
    }

    public boolean addSC(SelectClass selectClass) {
        if (selectClass.getCno() <= 0 || selectClass.getSno() <= 0 || selectClass.getSclass() <= 0 || selectClass.getGrade() <= 0) {
            return false;
        }
        try {
            scMapper.insertSC(selectClass);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateSC(SelectClass selectClass) {
        HashMap<String, Object> map = new HashMap<>();
        if (selectClass.getSclass() > 0) map.put("sclass", selectClass.getSclass());
        else return false;
        if (selectClass.getSno() > 0) map.put("sno", selectClass.getSno());
        else return false;
        if (selectClass.getCno() > 0) map.put("cno", selectClass.getCno());
        else return false;
        if (selectClass.getGrade() > 0) map.put("grade", selectClass.getGrade());
        else return false;
        try {
            scMapper.updateSC(map);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
