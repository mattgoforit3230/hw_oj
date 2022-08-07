package algorithm.a_leecodeEveryday.a_demo2021_8;

import java.util.*;

public class Demo819 {
    public static void main(String[] args) {
        String hello = reverseVowels("hello");
        System.out.println(hello);
    }
    /**
     * 345. 反转字符串中的元音字母
     */
    public static String reverseVowels(String s) {
       HashSet<Character> set = new HashSet<Character>();
        String vowel = "aeiouAEIOU";
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < vowel.length(); i++) {
            set.add(vowel.charAt(i));
        }
        //set.add('a','e','i','o','u','A','E','I','O','U');
        int left = 0,right = s.length()-1;
        while(left < right){
            while(!set.contains(s.charAt(left)) && left<right){
                left++;
            }
            while(!set.contains(s.charAt(right)) && left<right){
                right--;
            }
            char temp = s.charAt(left);
            sb.setCharAt(left,s.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}
