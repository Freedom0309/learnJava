package com.freedom.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa9v8i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author LiuFeng
 * @version 2022/1/12 20:29
 * @since
 */
public class WordBreak2 {


    private static List<List<String>> sentenceWord = new ArrayList<>();
    private static List<String> words = new ArrayList<>();
    private static Set<Integer> wordSet = new HashSet<>();


    public static void updateWordSet(List<String> wordDict) {
        wordDict.forEach(dict -> {
            wordSet.add(dict.length());
        });
    }

    public static void dfs(String str, Integer m, List<String> dicts) {
        int length = str.length();
        if (m == str.length()) {
            sentenceWord.add(new ArrayList<>(words));
            words.clear();
            return;
        }

        Iterator<Integer> iterator = wordSet.iterator();
        while (iterator.hasNext()) {
            Integer count = iterator.next();
            if (m + count > length) continue;
            String substring = str.substring(m, m + count);
            if (dicts.contains(substring)) {
                words.add(substring);
                dfs(str, m + count, dicts);
            }
        }

    }

    public static List<String> createSentence(List<List<String>> sentenceWord) {
        List<String> sentences = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (List<String> lists : sentenceWord) {
            for (String str : lists) {
                builder.append(str).append(" ");
            }
            builder.delete(builder.length() - 1, builder.length());
            sentences.add(builder.toString());
            builder.delete(0, builder.length());
        }

        return sentences;
    }


    public static void main(String[] args) {
        String str = "pineapplepenapple";
        List<String> wordDicts = new ArrayList<>();
        wordDicts.add("apple");
        wordDicts.add("pen");
        wordDicts.add("applepen");
        wordDicts.add("pine");
        wordDicts.add("pineapple");

//        updateWordSet(wordDicts);
//        dfs(str, 0, wordDicts);
//
//        List<String> sentence = createSentence(sentenceWord);
//
//        sentence.forEach(System.out::println);

        List<String> sentences = wordBreak(str, wordDicts);
        sentences.forEach(System.out::println);

    }


    public static List<String> wordBreak(String str, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = str.length();

        boolean[] dp = new boolean[len + 1];

        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            for (int left = right - 1; left >= 0; left--) {
                if (wordSet.contains(str.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    break;
                }
            }
        }

        List<String> result = new ArrayList<>();

        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(str, len, wordSet, dp, path, result);
        }
        return result;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param str
     * @param len
     * @param wordSet
     * @param dp
     * @param path
     * @param result
     */
    public static void dfs(String str, int len, Set<String> wordSet, boolean[] dp,
                           Deque<String> path, List<String> result) {

        if (len == 0) {
            result.add(String.join(" ", path));
            return;
        }


        for (int i = len - 1; i >= 0; i--) {

            String suffix = str.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(str, i, wordSet, dp, path, result);
                path.removeFirst();
            }

        }

    }
}
