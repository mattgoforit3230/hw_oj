package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 寻找相同子串
 *  给你两个字符串 t 和 p ，要求从 t 中找到一个和 p 相同的连续子串，并输出该字串第一个字符的下标。
 */
public class Interview114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String p = sc.nextLine();
        int index = t.indexOf(p);
        if(index == -1){
            System.out.println("No");
        }else{
            System.out.println(index + 1);
        }
    }
}
