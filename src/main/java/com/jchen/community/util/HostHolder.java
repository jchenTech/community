package com.jchen.community.util;

import com.jchen.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息，用于代替session对象
 * @Auther: jchen
 * @Date: 2021/03/29/20:33
 */
@Component
public class HostHolder {

    //在存储用户信息的时候需要考虑多线程的情况，不然会在并发的时候产生冲突，必须考虑线程隔离
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
