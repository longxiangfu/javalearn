package com.spring.spring.beanLifeCycle.service;

import com.spring.spring.beanLifeCycle.bean.User;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements InitializingBean, BeanNameAware {

    @Autowired
    private User user;

    private String name;

    private String beanName;

    private String userName;

    /**
     * 初始化 即可以在这里设置普通属性
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "longxiangfu";
    }

    /**
     * 获取bean的名字
     * 在初始化中执行
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
