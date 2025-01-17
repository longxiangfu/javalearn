package com.tc.hutoolTest.utilTest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.net.NetUtil;

/**
 * NetUtil 网络工具
 */
public class NetTest {
    public static void main(String[] args) {
        String ip= "127.0.0.1";
        long iplong = 2130706433L;

        String ipv4 = NetUtil.longToIpv4(iplong);
        Console.log(ipv4); // 127.0.0.1

        long ipv4ToLong = NetUtil.ipv4ToLong(ip);
        Console.log(ipv4ToLong); // 2130706433

        boolean usableLocalPort = NetUtil.isUsableLocalPort(6379);
        Console.log(usableLocalPort); // true

        boolean validPort = NetUtil.isValidPort(6379);
        Console.log(validPort); // true

        String hideIpPart = NetUtil.hideIpPart(ip);
        Console.log(hideIpPart); // 127.0.0.*


    }
}
