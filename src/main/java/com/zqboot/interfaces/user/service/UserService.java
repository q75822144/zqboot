package com.zqboot.interfaces.user.service;

import com.zqboot.interfaces.user.dao.UserMapper;
import com.zqboot.interfaces.user.model.User;
import com.zqboot.utils.PageUtil;
import com.zqboot.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

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
     * @param user 用户对象
     */
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id 主键
     */
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    public Map<String, Object> listUser(PageUtil pageUtil) {
        int total = userMapper.countUser(pageUtil);
        pageUtil.put(PageUtil.TOTAL, total);
        pageUtil.put(ResultResponse.ROWS, userMapper.listUser(pageUtil));
        return pageUtil;
    }
}
