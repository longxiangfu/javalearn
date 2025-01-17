package com.tc.hutoolTest.utilTest;

import cn.hutool.core.lang.Console;
import cn.hutool.dfa.WordTree;

import java.util.List;

/**
 * DFA查找
 * 关键词构造一棵树，然后用正文遍历这颗树
 * 树其实就是HashMap
 */
public class DfaTest {
    public static void main(String[] args) {
        // 构建关键词树
        WordTree tree = new WordTree();
        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");

        // 正文
        String text = "我有一颗大土豆，刚出锅的";

        // 标准匹配，匹配最短关键词，并跳过已经匹配的关键词；还有其他匹配方式
        // 匹配到【大】，就不再继续匹配了，因此【大土豆】不匹配
        // 匹配到【刚出锅】，就跳过这三个字了，因此【出锅】不匹配（由于刚首先被匹配，因此长的被匹配，最短匹配只针对第一个字相同选最短）
        List<String> list = tree.matchAll(text, -1, false, false);
        Console.log(list); // [大, 土豆, 刚出锅]

        // 获取第一个匹配的关键词
        String match = tree.match(text);
        Console.log(match); // 大

        // 是否匹配
        Console.log(tree.isMatch(text)); // true

    }
}
