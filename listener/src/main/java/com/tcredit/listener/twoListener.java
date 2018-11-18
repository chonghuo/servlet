package com.tcredit.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Auther: chong.huo
 * Create  Date: 2018/11/18
 */
public class twoListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加数据行为");

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("更新数据行为");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("删除数据行为");
    }
}
