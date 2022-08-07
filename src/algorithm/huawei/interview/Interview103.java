package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 乱序整数序列两数之和绝对值最小
 *  给定一个随机的整数(可能存在正整数和负整数)数组 nums，请你在该数组中找出两个数，
 *  其和 的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个两个数(按从小到大返回)以及绝对值。
 * 每种输入只会对应一个答案。
 * 但是，数组中同一个元素不能使用两遍。
 -1 -3 7 5 11 15
 =>-3 5 2
 */
public class Interview103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split("\\s+");
        int n  =split.length;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            if(split[i].charAt(0) == '-'){
                ints[i] = -1*Integer.parseInt(split[i].substring(1));
            }else{
                ints[i] = Integer.parseInt(split[i]);
            }
        }
        int a = ints[0], b =  ints[1] , min = Math.abs(a + b);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i+1; j < ints.length; j++) {
                if(Math.abs(ints[i] + ints[j]) < min){
                    min = Math.abs(ints[i] + ints[j]);
                    a = ints[i];
                    b = ints[j];
                }
            }
        }
        if(a > b){
            System.out.println(b +" "+a+" "+min);
        }else{
            System.out.println(a +" "+b+" "+min);
        }
    }
}
