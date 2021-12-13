package xyz.soulspace.connect_test.service;

import xyz.soulspace.connect_test.mapper.UserMapper;
import xyz.soulspace.connect_test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User getByName(String username) {
        return userMapper.findByUsername(username);
    }

    public User get(String username, String password){
        User user = userMapper.getByUsernameAndPassword(username, password);
        return user;
    }

    public void add(User user){
        userMapper.addUser(user);
    }
}
