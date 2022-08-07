package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 83 分糖果
 * 小明从糖果盒中随意抓一把糖果，每次小明会取出一半的糖果分给同学们。
 * 当糖果不能平均分配时，小明可以选择从糖果盒中(假设盒中糖果足够)取出一个糖果或放回一个糖果。
 * 小明最少需要多少次(取出、放回和平均分配均记一次)，能将手中糖果分至只剩一颗。
 */
public class Interview83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        System.out.println(count(l,0));
    }

    private static int count(long l, int i) {
        if(l <= 1)return i;
        if((l & 1) == 0)return count(l>>1,i+1);
        return Math.min(count(l+1,i+1),count(l-1,i+1));
    }
}
