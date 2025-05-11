package com.tc.jdk.foundation.string;

/**
 * 自定义十进制和62进制转换
 */
public class JinzhiZhuanHuan {
    private static final String BASE_62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
//        long binaryNumber = 123456789L;
        long binaryNumber = 80L;
        String base62 = binaryToBase62(binaryNumber);
        System.out.println("Binary to Base62: " + base62); // Binary to Base62: 8m0Kx

        long convertedBack = base62ToBinary(base62);
        System.out.println("Base62 to Binary: " + convertedBack); // Base62 to Binary: 123456789
    }

    /**
     * 十进制转62进制
     * @param binaryNumber
     * @return
     */
    public static String binaryToBase62(long binaryNumber) {
        if (binaryNumber == 0) {
            return String.valueOf(BASE_62_CHARS.charAt(0));
        }
        StringBuilder base62 = new StringBuilder();
        while (binaryNumber > 0) {
            int remainder = (int) (binaryNumber % 62);
            base62.insert(0, BASE_62_CHARS.charAt(remainder));
            binaryNumber /= 62;
        }
        return base62.toString();
    }

    /**
     * 62进制转十进制
     * @param base62Number
     * @return
     */
    public static long base62ToBinary(String base62Number) {
        long binaryNumber = 0;
        for (int i = 0; i < base62Number.length(); i++) {
            char c = base62Number.charAt(i);
            int value = BASE_62_CHARS.indexOf(c);
            binaryNumber = binaryNumber * 62 + value;
        }
        return binaryNumber;
    }


}
