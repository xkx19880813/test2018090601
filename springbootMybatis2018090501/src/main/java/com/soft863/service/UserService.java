package com.soft863.service;

import com.soft863.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<Map<String,Object>> queryUsers() {
        return userDao.queryUsers();
    }

    public void delete() {
        userDao.deleteUser(1);
    }
}
