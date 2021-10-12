package com.freedom.palindrome;

/**
 * Copyright: Copyright (c) 2021 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2021/4/12 17:15
 * @since
 */
public class PalindromeTest {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.setNext(new Node(2));
        node.getNext().setNext(new Node(3).setNext(new Node(2).setNext(new Node(1))));
        System.out.println(node);

        boolean palindrome = node.isPalindrome(node);
        System.out.println(palindrome);
    }


}
