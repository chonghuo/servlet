package com.tcredit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Auther: chong.huo
 * Create  Date: 2018/11/17
 */
public class myListener implements ServletContextListener {

    /**
     *  在全局作用域对象被tomcat创建后触发调用
     *  @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用域对象被创建");
    }


    /**
     * 在全局作用域对象将要被tomcat销毁时调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用域对象被销毁");
    }
}
