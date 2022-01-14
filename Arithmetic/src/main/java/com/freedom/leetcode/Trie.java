package com.freedom.leetcode;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 前缀树
 *
 * @author LiuFeng
 * @version 2022/1/13 16:41
 * @since
 */
public class Trie {

    private Trie[] children;
    private Boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        word = word.toLowerCase();

        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            int chIndex = ch - 'a';
            if (node.children[chIndex] == null) {
                node.children[chIndex] = new Trie();
            }
            node = node.children[chIndex];
        }
        node.isEnd = true;

    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startWith(String word) {
        Trie node = searchPrefix(word);
        return node != null;
    }

    private Trie searchPrefix(String prefix) {

        Trie node = this;

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
