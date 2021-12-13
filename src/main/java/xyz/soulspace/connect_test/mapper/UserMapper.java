package xyz.soulspace.connect_test.mapper;

import xyz.soulspace.connect_test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    void addUser(User user);
}
