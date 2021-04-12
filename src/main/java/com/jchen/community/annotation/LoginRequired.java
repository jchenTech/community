package com.jchen.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于拦截器进行登录状态检查
 * @Auther: jchen
 * @Date: 2021/03/30/10:04
 */
// 注解用来描述方法
@Target(ElementType.METHOD)
// 注解有效的时长：运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
