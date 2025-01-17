package com.tc.jdk.javaObject;


/**
 * 在堆内分配
 * 添加参数 -XX:+PrintGCDetails
 *
 * 我的虚拟机默认：
 * PSYoungGen      total 57344K  ->57M
 *   eden space 49152K ->49M
 *   from space 8192K ->8M
 *   to   space 8192K ->8M
 *  ParOldGen       total 131072K ->131M
 *
 *  大对象设置参数 -XX:PretenureSizeThreshold  单位是字节
 *  -XX:PretenureSizeThreshold=1000000 -XX:+UseSerialGC
 */
public class GcTest {
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6;
//        allocation1 = new byte[40000*1024]; // 40M
        allocation2 = new byte[8000*1024]; // 8M

//        allocation3 = new byte[1000*1024]; // 1M
//        allocation4 = new byte[1000*1024]; // 1M
//        allocation5 = new byte[1000*1024]; // 1M
//        allocation6 = new byte[1000*1024]; // 1M
    }
}
