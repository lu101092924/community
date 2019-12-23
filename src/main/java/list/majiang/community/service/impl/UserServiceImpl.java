package list.majiang.community.service.impl;

import list.majiang.community.mapper.UserMapper;
import list.majiang.community.model.User;
import list.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insertUser(user);
    }
}
