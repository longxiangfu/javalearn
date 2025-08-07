package com.tc.jdk.foundation.dataStructure;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 浮点数精确计算
 * 四舍五入
 */
public class FloatTest {
    public static void main(String[] args) {
        double a = 2.565;
        BigDecimal b = new BigDecimal(String.valueOf(a));
        BigDecimal c = b.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("四舍五入保持两位小数：" + c); // 四舍五入保持两位小数：2.57

        BigDecimal c1 = b.setScale(2, BigDecimal.ROUND_UP);
        System.out.println("向上取整保留两位小数：" + c1); // 向上取整保留两位小数：2.57

        BigDecimal c2 = b.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println("向下取整保留两位小数：" + c2); // 向下取整保留两位小数：2.56
    }
}
