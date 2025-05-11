package com.tc.jdk.foundation.string;

import com.google.common.hash.BloomFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class StringTest7 {
    public static void main(String[] args) {
        String a = "";
        for (int i = 0; i < 1000; i++) {
            // 有性能问题，每次操作都会重新创建一个对象
            // 可以用StringBuffer或StringBuilder来优化性能
            a += i;
        }





    }
}
