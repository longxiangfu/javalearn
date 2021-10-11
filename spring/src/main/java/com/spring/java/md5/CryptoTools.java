package com.spring.java.md5;

import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;


public class CryptoTools {
    private final byte[] DESkey = new byte[]{
        (byte)145,
        (byte)20,
        (byte)59,
        (byte)151,
        (byte)15,
        (byte)5,
        (byte)123,
        (byte)148,
    };
    private final byte[] DESIV = new byte[]{
            (byte) 99,
            (byte) 151,
            (byte) 132,
            (byte) 95,
            (byte) 49,
            (byte) 19,
            (byte) 140,
            (byte) 5
    };

    private AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
    private Key key = null;

    public CryptoTools() throws Exception {
        DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
        iv = new IvParameterSpec(DESIV);// 设置向量
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象

    }

    public String encode(String data) throws Exception {
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
        byte[] pasByte = enCipher.doFinal(data.getBytes(Charset.defaultCharset()));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(pasByte);
    }

    public String decode(String data) throws Exception {
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        BASE64Decoder base64Decoder = new BASE64Decoder();

        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));

        return new String(pasByte, "UTF-8");
    }


    public void parseByte()
            throws NumberFormatException {

//        File file = new File("C:\\Users\\Administrator\\Desktop\\demo1.txt");
        File file = new File("C:\\Users\\Administrator\\Desktop\\demo2.txt");
//        File file = new File("C:\\Users\\Administrator\\Desktop\\demo3.txt");
        // 读取
        try {
            List<String> fileStrList = FileUtils.readLines(file, Charset.defaultCharset());
            for (String str : fileStrList) {
//                System.out.println("原:" + str);
                byte result = 0;
                if(str.length() < 8){
                    result = Byte.parseByte(str,2);
                }else if(str.length() == 8 && str.startsWith("1")){
                    byte temp = Byte.parseByte(str.substring(1, str.length()-1),2);
                    result = (byte) (0 - temp);
                } else if (str.length() == 8 && str.startsWith("0")){
                    result = Byte.parseByte(str,2);
                }

                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 获取mac地址
     * @param IP
     * @return
     * @throws Exception
     */
    public static String getMacByIP(String IP) throws Exception {
        InetAddress ia = InetAddress.getByName(IP);
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< mac.length; i ++) {
            if(i != 0) {
                sb.append("-");
            }
            String hexString = Integer.toHexString(mac[i] & 0xFF);
            sb.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return sb.toString().toUpperCase();
    }



    public static void main(String[] args) {
        try {
            String test = "8C:16:45:B1:7D:90";
            CryptoTools des = new CryptoTools();//自定义密钥
//            des.parseByte();
            System.out.println("加密前："+test);
            System.out.println("加密后："+des.encode(test));
            System.out.println("解密后："+des.decode(des.encode(test)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
