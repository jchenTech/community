package com.jchen.community.dao;

import com.jchen.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper映射接口
 *
 * @Auther: jchen
 * @Date: 2021/03/28/12:08
 */
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
