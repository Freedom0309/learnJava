package com.freedom.leetcode;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 验证字符串是否史回文串
 *
 * @author LiuFeng
 * @version 2022/1/11 20:59
 * @since
 */
public class Palindrome {


    public static boolean isPalindrome(String str) {

        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(str);

        int length = str.length();



        int remainder = length % 2;

        System.out.println(remainder);
        int mid = length / 2;
//        if (remainder == 1)
//            mid = length / 2;
//        else
//            mid = length / 2;
        System.out.println(mid);
        boolean flag = true;
        int low = 0, high = 0;

        if (remainder == 1) {
            low = mid - 1;
            high = mid + 1;
        } else {
            low = mid - 1;
            high = mid;
        }
        System.out.println(low + " " + high);

        for (int i = 0; i < mid; i++) {
//            System.out.println(str.charAt(low--));
//            System.out.println(str.charAt(high++));
            if (str.charAt(low--) != str.charAt(high++)) {
                flag = false;
                break;
            }
        }


        return flag;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str1 = "0P";
//        boolean palindrome = isPalindrome(str);
//        System.out.println(palindrome);
        boolean palindrome1 = isPalindrome(str1);
        System.out.println(palindrome1);
    }
}
