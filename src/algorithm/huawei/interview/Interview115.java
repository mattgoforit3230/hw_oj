package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 找出符合要求的字符串子串
 *给定两个字符串，从字符串2中找出字符串1中的所有字符，去重并按照ASCII值从小到大排序。
 * 输入字符串1:⻓度不超过1024 输入字符串2:⻓度不超过1000000 字符范围满足ASCII编码要求，
 * 按照ASCII的值由小到大排序
 bach
 bbaaccedfg
 =>abc
 fach
 bbaaccedfg
 =>acf
 */
public class Interview115 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine().trim();
        String str2 = scanner.nextLine().trim();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            if(set.contains(str2.charAt(i))){
                list.add(str2.charAt(i));
                set.remove(str2.charAt(i));
            }
        }
        list.sort((a,b)->a-b);
        StringBuilder res = new StringBuilder();
        for(char cur:list)res.append(cur);
        System.out.println(res);
    }
}
