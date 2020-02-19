package com.it.shw.oom.mapper;

import com.it.shw.oom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Copyright: Harbin Institute of Technology.All rights reserved.
 * @Description:
 * @author: thailandking
 * @since: 2020/2/19 15:14
 * @history: 1.2020/2/19 created by thailandking
 */
@Component
@Mapper
public interface UserMapper {
    List<User> getAllUserList();
}
