package com.it.shw.oom.controller;

import com.it.shw.oom.entity.User;
import com.it.shw.oom.mapper.UserMapper;
import com.it.shw.oom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Copyright: Harbin Institute of Technology.All rights reserved.
 * @Description: 用户controller
 * @author: thailandking
 * @since: 2020/2/19 15:18
 * @history: 1.2020/2/19 created by thailandking
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/query")
    public List<User> testQuery() {
        List<User> userList = userMapper.getAllUserList();
        userList.forEach(item -> System.out.println(item));
        return userList;
    }

    @GetMapping(value = "/export")
    public void testCsvExport(HttpServletResponse response) {
        String fileName = System.currentTimeMillis() + ".csv";
        response.addHeader("Content-Type", "application/csv");
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setCharacterEncoding("UTF-8");
        userService.exportUserWithCsv(response);
    }
}
