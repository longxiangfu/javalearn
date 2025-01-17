package com.tc.hutoolTest.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import cn.hutool.log.level.Level;

/**
 * 基本用法：1、LogFactory.get();  2、StaticLog
 * 自定义日志工厂： 继承LogFactory，实现createLog方法
 */
public class LogTest {
    private static final Log log = LogFactory.get();

    public void test(){
        log.info("This is {} log", Level.INFO);
        log.error("This is {} log", Level.ERROR);
        Exception e = new Exception("test exception");
        log.error(e, "This is {} log", Level.ERROR);

//        StaticLog.info("This is {} log", "INFO");
    }
}
