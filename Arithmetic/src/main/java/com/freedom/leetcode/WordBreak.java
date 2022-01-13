package com.freedom.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa503c/
 *
 * @author LiuFeng
 * @version 2022/1/12 19:01
 * @since
 */
public class WordBreak {

    public static boolean wordBreak(String str, List<String> wordDict) {
        int len = str.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        String str = "applepenapple";
        List<String> wordDicts = new ArrayList<>();
        wordDicts.add("apple");
        wordDicts.add("pen");
        wordDicts.add("banana");

        boolean b = wordBreak(str, wordDicts);
        System.out.println(b);

        String str1 = "cars";

        List<String> wordDicts1 = new ArrayList<>();
        wordDicts1.add("car");
        wordDicts1.add("ca");
        wordDicts1.add("rs");
        System.out.println(wordBreak(str1, wordDicts1));

    }
}
