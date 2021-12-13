package xyz.soulspace.connect_test.controller;

import xyz.soulspace.connect_test.pojo.User;
import xyz.soulspace.connect_test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Controller
public class LoginController {
    private UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody User requestUser, HttpSession session) {
        LOGGER.info("POST login" + requestUser);
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username, requestUser.getPassword());

        if (null == user) {
            return new ResponseEntity<>("No user", HttpStatus.NOT_FOUND);
        } else {
            session.setAttribute("loginUser", user);
            LOGGER.info(username + " login");
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/login_test")
    @ResponseBody
    public ResponseEntity<?> login_test(@RequestBody User requestUser, HttpSession session) {
        System.out.println(requestUser);
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new ResponseEntity<>("No user", HttpStatus.NOT_FOUND);
        } else {
            session.setAttribute("loginUser", user);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody User registerUser) {
        if (userService.isExist(registerUser.getUsername())) {
            return new ResponseEntity<>("username has existed!", HttpStatus.FAILED_DEPENDENCY);
        }
        try {
            userService.add(registerUser);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "api/backup")
    @ResponseBody
    public ResponseEntity<?> backup() {
        LOGGER.warn("Backup");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
