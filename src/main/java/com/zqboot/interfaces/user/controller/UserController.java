package com.zqboot.interfaces.user.controller;

import com.zqboot.constant.Constants;
import com.zqboot.interfaces.user.model.User;
import com.zqboot.interfaces.user.service.UserService;
import com.zqboot.utils.HttpUtils;
import com.zqboot.utils.PageUtil;
import com.zqboot.utils.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhouquan on 2017/10/23.
 */
@RestController
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.POST)
    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getId());
        ResultResponse resp = new ResultResponse();
        try {
            User user = HttpUtils.convert(request, User.class);
            userService.addUser(user);
            resp.setMsg(Constants.ADD_SUCCESS);
            resp.setResult(true);
        } catch (Exception e) {
            resp.setMsg(Constants.ADD_FAIL);
            resp.setResult(false);
            log.error("新增用户失败，错误信息为：", e);
        } finally {
            resp.write(response);
        }
    }

    /**
     * 删除用户
     *
     * @param id
     * @param response
     */
    @RequestMapping(value = "/app/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        try {
            userService.deleteUser(id);
            resp.setMsg(Constants.DELETE_SUCCESS);
            resp.setResult(true);
        } catch (Exception e) {
            resp.setMsg(Constants.DELETE_FAIL);
            resp.setResult(false);
            log.error("删除用户失败，错误信息为：", e);
        } finally {
            resp.write(response);
        }
    }

    /**
     * 修改用户
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        try {
            User user = HttpUtils.convert(request, User.class);
            userService.updateUser(user);
            resp.setMsg(Constants.UPDATE_SUCCESS);
            resp.setResult(true);
        } catch (Exception e) {
            resp.setMsg(Constants.UPDATE_FAIL);
            resp.setResult(false);
            log.error("修改用户失败，错误信息为：", e);
        } finally {
            resp.write(response);
        }
    }

    /**
     * 通过id查询用户信息
     *
     * @param id
     * @param response
     */
    @RequestMapping(value = "/app/user/{id}", method = RequestMethod.GET)
    public void findUserById(@PathVariable int id, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        try {
            User user = userService.findUserById(id);
            resp.push("jsonObj", user);
            resp.setMsg(Constants.SELECT_SUCCESS);
            resp.setResult(true);
        } catch (Exception e) {
            resp.setMsg(Constants.SELECT_FAIL);
            resp.setResult(false);
            log.error("通过id查询用户信息失败，错误信息为：", e);
        } finally {
            resp.write(response);
        }
    }

    /**
     * 分页查询用户信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.GET)
    public void listUser(HttpServletRequest request, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        try {
            PageUtil pageUtil = new PageUtil(request);
            List<User> users = userService.listUser(pageUtil);
            resp.push("jsonList",users);
            resp.push("total",pageUtil.get("total"));
            resp.setMsg(Constants.SELECT_SUCCESS);
            resp.setResult(true);
        } catch (Exception e) {
            resp.setMsg(Constants.SELECT_FAIL);
            resp.setResult(false);
            log.error("分页查询用户信息失败，错误信息为：", e);
        } finally {
            resp.write(response);
        }
    }

}
