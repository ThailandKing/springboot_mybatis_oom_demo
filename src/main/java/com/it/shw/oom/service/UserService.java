package com.it.shw.oom.service;

import com.it.shw.oom.entity.User;
import com.it.shw.oom.handler.CallbackProcess;
import com.it.shw.oom.handler.UserResultHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @Copyright: Harbin Institute of Technology.All rights reserved.
 * @Description:
 * @author: thailandking
 * @since: 2020/2/19 16:12
 * @history: 1.2020/2/19 created by thailandking
 */
@Service
public class UserService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * @Author thailandking
     * @Date 2020/2/19 17:00
     * @LastEditors thailandking
     * @LastEditTime 2020/2/19 17:00
     * @Description 导出用户列表CSV
     */
    public void exportUserWithCsv(HttpServletResponse response) {
        // 结果集处理回调过程
        CallbackProcess callbackProcess = new CallbackProcess(response);
        // 结果集分批处理
        UserResultHandler userResultHandler = new UserResultHandler<User>(callbackProcess, 1000);
        sqlSessionTemplate.select("com.it.shw.oom.mapper.UserMapper.getAllUserList", userResultHandler);
        // 处理最后一批数据
        userResultHandler.end();
    }
}
