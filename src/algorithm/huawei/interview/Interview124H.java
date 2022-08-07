package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 转骰子
 * 骰子是一个立方体，每个面一个数字，初始为左1，右2，前3(观察者方向)，后4，上5，下6，用 123456表示这个状态，放置在平面上，
 *  可以向左翻转(用L表示向左翻转1次)，
 *  可以向右翻转(用R表示向右翻转1次)，
 *  可以向前翻转(用F表示向前翻转1次)，
 *  可以向后翻转(用B表示向后翻转1次)，
 *  可以逆时针旋转(用A表示逆时针旋转90度)，
 *  可以顺时针旋转(用C表示顺时针旋转90度)，
 *  现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。
 *
 *  输入一行，为只包含LRFBAC的字母序列，最大⻓度为50，字母可重复。
 *
 LR
 =>123456
 LRBBC
 432165
 */
public class Interview124H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int[] res = new int[]{1,2,3,4,5,6};
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == 'L'){
                swap(res,0,1,4,5);
            }else if(cur == 'R'){
                swap(res,5,4,1,0);
            }else if(cur == 'F'){
                swap(res,2,4,3,5);
            }else if(cur == 'B'){
                swap(res,5,3,4,2);
            }else if(cur == 'A'){
                swap(res,0,3,1,2);
            }else{
                swap(res,2,1,3,0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a:res)sb.append(a);
        System.out.println(sb);
    }

    private static void swap(int[] res, int a, int b, int c, int d) {
        int temp = res[a];
        res[a] = res[b];
        res[b] = res[c];
        res[c] = res[d];
        res[d] = temp;
    }
}
