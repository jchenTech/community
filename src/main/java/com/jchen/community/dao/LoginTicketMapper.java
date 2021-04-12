package com.jchen.community.dao;

import com.jchen.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * 登陆凭证接口
 * @Auther: jchen
 * @Date: 2021/03/29/18:14
 */
@Mapper
@Deprecated
public interface LoginTicketMapper {

    /**
     * 插入登陆凭证数据
     * @param loginTicket 登陆凭证
     */
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    /**
     * 查询登录凭证
     * @param ticket ticket字符串
     * @return 登陆凭证
     */
    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    /**
     * 更新状态status， 0-有效；1-无效
     * @param ticket ticket字符串
     * @param status 登录状态
     */
    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, int status);

}
