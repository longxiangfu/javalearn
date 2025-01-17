package com.tc.hutoolTest.cron;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;

/**
 * 定时任务
 */
public class TestJob {
    public static void main(String[] args) {
        // 动态添加定时任务，该任务不会添加到配置文件中
        CronUtil.schedule("*/1 * * * *", (Task) () -> Console.log("Task executed"));

        // 尝试查找config/cron.setting中的任务
        CronUtil.start();
    }


    public void run() {
        System.out.println(DateUtil.now() + " 执行定时任务");
    }
}
