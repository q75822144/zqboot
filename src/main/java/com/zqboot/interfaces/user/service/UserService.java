package com.zqboot.interfaces.user.service;

import com.zqboot.interfaces.user.dao.UserMapper;
import com.zqboot.interfaces.user.model.User;
import com.zqboot.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhouquan on 2017/11/13.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     *
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     */
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    public List<User> listUser(PageUtil pageUtil) {
        int total = userMapper.countUser(pageUtil);
        pageUtil.put("total", total);
        return userMapper.listUser(pageUtil);
    }
}
