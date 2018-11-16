package com.tefg.lister;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName StratSystemLister
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\15 001517:47
 * @Version 1.0
 **/
public class StratSystemLister implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent src) {
        //1.将上下文路径(request.getContextPath)放到application域中
        ServletContext application=src.getServletContext();
        String contextPath=application.getContextPath();
        application.setAttribute("APP_PATH",contextPath);
        System.out.println("APP_PATH");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
