package com.freedom.IO;

import org.junit.Test;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 14:58 2017/12/26
 * @Modified By:
 **/
public class PalindromeTest {

    @Test
    public void PalindromeTest() {
        String str = "12321";
        String str1 = "abcba";
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome(str);
        System.out.println("next method:");
        palindrome.directComparePalindrome(str1);
        System.out.println("cutOutChar method:");
        palindrome.cutOutChar(str);
    }
}
