package com.freedom;

import java.util.ArrayList;
import java.util.List;

import com.freedom.leetcode.Trie;
import org.junit.Test;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:
 *
 * @author LiuFeng
 * @version 2022/1/13 17:56
 * @since
 */
public class TrieTest {

    /**
     * ["Trie","insert","search","search","startsWith","insert","search"]
     * [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
     */
    @Test
    public void test(){
        List<String> words = new ArrayList<>();
        words.add("Trie");
        words.add("insert");
        words.add("search");
        words.add("search");
        words.add("startsWith");
        words.add("insert");
        words.add("search");
        Trie node = new Trie();

        node.insert("apple");
        node.insert("search");
        node.insert("startswith");

        System.out.println(node.search("insert"));
        System.out.println(node.startWith("start"));

        System.out.println(node.search("apple"));
    }
}
