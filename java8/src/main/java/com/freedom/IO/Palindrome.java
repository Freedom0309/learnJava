package com.freedom.IO;

/**
 * 判断一个字符串是否回文
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 14:33 2017/12/26
 * @Modified By:
 **/
public class Palindrome {

    /**
     * 将字符串倒置后，在逐一比较
     * @param str
     */
    public void isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        //旋转字符串
        sb.reverse();
        int count = 0;
        //逐个进行比较
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sb.charAt(i)) {
                count++;
            }
        }

        if (count == str.length()) {
            System.out.println(str + "是回文字符串");
        } else {
            System.out.println(str + "不是回文字符串");
        }
    }

    /**
     * 将字符串倒置后创建新的字符串，然后与原字符串进行比较
     * @param str
     */
    public void directComparePalindrome(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        //旋转字符串
        stringBuilder.reverse();
        System.out.println(str + " : " + stringBuilder);
        //创建一个新的字符串，即把StringBuilder转换成String.
        String newstr = new String(stringBuilder);
        //利用equals()方法进行判断两个字符串是否相等
        if (str.equals(newstr)) {
            System.out.println(str + "是回文字符串");
        } else {
            System.out.println(str + "不是回文字符串");

        }
    }

    /**
     * 使用截取字符串的方式比较
     * @param str
     */
    public void cutOutChar(String str){
        int count = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            //对字符串进行截取
            if ((str.substring(i, i+1)).equals(str.substring(str.length() - 1 - i, str.length() - i))) {
                count++;
            }
        }

        if (count == str.length() / 2) {
            System.out.println(str + "是一个回文字符串");
        } else {
            System.out.println(str + "不是一个回文字符串");
        }

    }
}
