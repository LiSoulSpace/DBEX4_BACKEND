package xyz.soulspace.connect_test.controller;

import xyz.soulspace.connect_test.pojo.Class;
import xyz.soulspace.connect_test.result.Result;
import xyz.soulspace.connect_test.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ClassController {
    private ClassService classService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/api/queryClasses")
    @ResponseBody
    public ResponseEntity<?> queryClassesListP(@RequestBody Class class_t) {
        LOGGER.info("POST queryClassesList: " + class_t);
        Result<?> result = classService.getClass(class_t);
        return new ResponseEntity<>(result.getBody(), result.getStatus());
    }

    @CrossOrigin
    @GetMapping("/api/queryClasses")
    @ResponseBody
    public ResponseEntity<?> queryClassesList(@RequestBody Class class_t) {
        LOGGER.info("GET queryClassesList: " + class_t);
        Result<?> result = classService.getClass(class_t);
        return new ResponseEntity<>(result.getBody(), result.getStatus());
    }

    @PostMapping("/api/addClass")
    @ResponseBody
    public ResponseEntity<?> addClass(@RequestBody Class class_t) {
        LOGGER.info("POST addClass: " + class_t);
        Result<?> result = classService.addClass(class_t);
        return new ResponseEntity<>(result.getBody(), result.getStatus());
    }

    @PostMapping("/api/deleteClass")
    @ResponseBody
    public ResponseEntity<?> deleteClass(@RequestBody Class class_t) {
        LOGGER.info("POST deleteClass: "+class_t);
        Result<?> result = classService.deleteClass(class_t);
        return new ResponseEntity<>(result.getBody(), result.getStatus());
    }

    @PostMapping("/api/updateClass")
    @ResponseBody
    public ResponseEntity<?> updateClass(@RequestBody Class class_t) {
        LOGGER.info("POST updateClass: "+class_t);
        Result<?> result = classService.updateClass(class_t);
        return new ResponseEntity<>(result.getBody(), result.getStatus());
    }

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
