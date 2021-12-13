package xyz.soulspace.connect_test.controller;

import xyz.soulspace.connect_test.pojo.SelectClass;
import xyz.soulspace.connect_test.service.SCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SCController {
    private SCService scService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SCController.class);

    @Autowired
    public void setScService(SCService scService) {
        this.scService = scService;
    }

    @PostMapping("/api/querySCs")
    @ResponseBody
    public ResponseEntity<?> querySCsListP(@RequestBody SelectClass selectClass) {
        List<SelectClass> selectClassList = scService.getSC(selectClass);
        LOGGER.info(selectClassList.toString());
        return new ResponseEntity<>(selectClassList, HttpStatus.OK);
    }

    @GetMapping("/api/querySCs")
    @ResponseBody
    public List<SelectClass> querySCsList(@RequestBody SelectClass selectClass) {
        List<SelectClass> selectClassList = scService.getSC(selectClass);
        LOGGER.info(selectClassList.toString());
        return selectClassList;
    }

    @PostMapping("/api/addSC")
    @ResponseBody
    public ResponseEntity<?> addSC(@RequestBody SelectClass selectClass) {
        try {
            boolean t = scService.addSC(selectClass);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/api/deleteSC")
    @ResponseBody
    public ResponseEntity<?> deleteSC(@RequestBody SelectClass selectClass) {
        try {
            boolean t = scService.deleteSC(selectClass);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/api/updateSC")
    @ResponseBody
    public ResponseEntity<?> updateSC(@RequestBody SelectClass selectClass) {
        try {
            boolean t = scService.updateSC(selectClass);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>("warning", HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
