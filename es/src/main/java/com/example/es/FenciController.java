package com.example.es;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;

/**
 * 分词器  HanLP
 */
public class FenciController {
    public static void main(String[] args) {
        // 标准分词器，还有其他的分词
        System.out.println(HanLP.segment("我喜欢图灵书院")); // [我/r, 喜欢/v, 图灵/nrf, 书院/n]
        System.out.println(HanLP.segment("攻城狮逆袭单身狗")); // [攻城/vi, 狮/ng, 逆袭/nz, 单身/n, 狗/n]

        // 自定义字典
        CustomDictionary.add("攻城狮");
        CustomDictionary.add("单身狗");
        System.out.println(HanLP.segment("攻城狮逆袭单身狗")); // [攻城狮/nz, 逆袭/nz, 单身狗/nz]

    }
}
