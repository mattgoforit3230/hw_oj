package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 关联子串
 *  给定两个字符串str1和str2， str1进行排列组合只要有一个为str2的子串,
 *  则认为str1是str2的关联子串， 请返回子串在str2的起始位置，若不是关联子串则返回-1。
 *
 abc efghicbaiii
 =》5
 abc efghiccaiii
 =》-1
 aab wejieabbaeiabaei
 =>11
 aaa aabaacaavaaaa
 =>9
 */
public class Interview110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split("\\s+");
        System.out.println(fun(split[0],split[1]));
    }

    private static int fun(String a, String b) {
        int[] ints = new int[26];
        int diff = 0,len = a.length();
        for (int i = 0; i < len; i++) {
            ints[a.charAt(i)-'a']++;
            ints[b.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(ints[i]!=0)diff++;
        }
        if(diff == 0)return 0;
        for (int l = 0,r = len; r < b.length();l++, r++) {
            char out = b.charAt(l),in = b.charAt(r);
            if(ints[out-'a'] == 0)diff++;
            if(ints[in-'a'] == 0)diff++;
            ints[out-'a']++;
            ints[in-'a']--;
            if(ints[out-'a'] == 0)diff--;
            if(ints[in-'a'] == 0)diff--;
            if(diff == 0)return l+1;
        }
        return -1;
    }
}
