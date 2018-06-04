package com.zqboot.interfaces.user.controller;

import com.zqboot.constant.Constants;
import com.zqboot.interfaces.user.model.User;
import com.zqboot.interfaces.user.service.UserService;
import com.zqboot.utils.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 描述：新增用户
     *
     * @param request
     * @param response
     * @return
     * @author zhouquan
     * @date 2018/3/22 16:01
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.POST)
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultResponse resp = new ResultResponse();
        User user = HttpUtils.convert(request, User.class);
        userService.addUser(user);
        resp.setMsg(Constants.ADD_SUCCESS);
        resp.write(response);
    }

    /**
     * 描述：删除用户
     *
     * @param id
     * @param response
     * @return
     * @author zhouquan
     * @date 2018/3/22 16:01
     */
    @RequestMapping(value = "/app/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        userService.deleteUser(id);
        resp.setMsg(Constants.DELETE_SUCCESS);
        resp.write(response);
    }

    /**
     * 描述：修改用户
     *
     * @param request
     * @param response
     * @return
     * @author zhouquan
     * @date 2018/3/22 16:01
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultResponse resp = new ResultResponse();
        User user = HttpUtils.convert(request, User.class);
        userService.updateUser(user);
        resp.setMsg(Constants.UPDATE_SUCCESS);
        resp.write(response);
    }

    /**
     * 描述：通过id查询用户
     *
     * @param id
     * @param response
     * @return
     * @author zhouquan
     * @date 2018/3/22 16:02
     */
    @RequestMapping(value = "/app/user/{id}", method = RequestMethod.GET)
    public void findUserById(@PathVariable int id, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        User user = userService.findUserById(id);
        resp.push(ResultResponse.ROW, user);
        resp.setMsg(Constants.SELECT_SUCCESS);
        resp.writeDateFormatAndStrategy(response,
                UtilEnum.DateFormatString.yyyy_MM_dd_HHmmSS.getValue(), SimpleStrategyFilter.getInstance());
    }

    /**
     * 描述：分页查询用户信息
     *
     * @param request
     * @param response
     * @return
     * @author zhouquan
     * @date 2018/3/22 18:56
     */
    @RequestMapping(value = "/app/user", method = RequestMethod.GET)
    public void listUser(HttpServletRequest request, HttpServletResponse response) {
        ResultResponse resp = new ResultResponse();
        PageUtil pageUtil = new PageUtil(request);
        Map<String, Object> res = userService.listUser(pageUtil);
        resp.setData(res);
        resp.setMsg(Constants.SELECT_SUCCESS);
        resp.writeDateFormatAndStrategy(response,
                UtilEnum.DateFormatString.yyyy_MM_dd_HHmmSS.getValue(), SimpleStrategyFilter.getInstance());
    }

}
