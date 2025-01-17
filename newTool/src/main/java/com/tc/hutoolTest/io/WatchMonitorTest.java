package com.tc.hutoolTest.io;

import cn.hutool.core.convert.Converter;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.util.StrUtil;

import java.io.Console;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * 监听文件或目录的变化
 */
public class WatchMonitorTest {
    public static void main(String[] args) throws InterruptedException {
        File file = FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.txt");
//        WatchMonitor watchMonitor =  WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
//        watchMonitor.setWatcher(new Watcher() {
//            @Override
//            public void onCreate(WatchEvent<?> event, Path currentPath) {
//
//            }
//
//            @Override
//            public void onModify(WatchEvent<?> event, Path currentPath) {
//
//            }
//
//            @Override
//            public void onDelete(WatchEvent<?> event, Path currentPath) {
//
//            }
//
//            @Override
//            public void onOverflow(WatchEvent<?> event, Path currentPath) {
//
//            }
//        });
//        watchMonitor.setMaxDepth(3); // 监听目录的最大深度
//        watchMonitor.start(); // 启动监听


        // SimpleWatcher  可以只重写想要监听的事件
        WatchMonitor watchMonitor = WatchMonitor.createAll(file, new SimpleWatcher(){
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                super.onModify(event, currentPath);
                Object context = event.context();
                System.out.println(StrUtil.format("修改：{}->{}", currentPath, context));
            }
        }).setMaxDepth(3);
        watchMonitor.start();
        System.out.println("开始监听文件修改");


        // 延迟监听，将在短时间内发生的改变事件合并处理
//        WatchMonitor watchMonitor = WatchMonitor.createAll(file, new DelayWatcher(new SimpleWatcher(){
//            @Override
//            public void onModify(WatchEvent<?> event, Path currentPath) {
//                super.onModify(event, currentPath);
//                Object context = event.context();
//                System.out.println(StrUtil.format("", currentPath, context));
//            }
//        }, 500)).setMaxDepth(3);
//        watchMonitor.start();

        Thread.sleep(10000);


//        开始监听文件修改
//        修改：C:\Users\Administrator\Desktop->1.txt
    }


}
