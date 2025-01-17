package com.tc.hutoolTest.utilTest;

import cn.hutool.extra.emoji.EmojiUtil;

/**
 * emoji表情符号处理
 */
public class EmojiUtilTest {
    public static void main(String[] args) {
        System.out.println(EmojiUtil.toAlias("\uD83D\uDE04")); // :smile:
        System.out.println(EmojiUtil.toUnicode(":smile:")); // 😄
    }
}
