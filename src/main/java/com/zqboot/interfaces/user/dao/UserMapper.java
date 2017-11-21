package com.zqboot.interfaces.user.dao;


import com.zqboot.interfaces.user.model.User;
import com.zqboot.utils.PageUtil;

import java.util.List;

/**
 * Created by zhouquan on 2017/11/13.
 */
public interface UserMapper {

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 多条件查询用户总数
     * @param pageUtil
     * @return
     */
    int countUser(PageUtil pageUtil);

    /**
     * 多条件分页查询用户列表
     * @param pageUtil
     * @return
     */
    List<User> listUser(PageUtil pageUtil);
}
