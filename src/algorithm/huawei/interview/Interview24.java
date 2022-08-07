package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 【编程题目 | 100分】小朋友排队 [ 2022 4月 考试题 ]
 * 输入 h , m
 * h表示小明的身高
 * m 表示下一行有 m 个人的身高
 * 要求输出与小明身高差最小的，按照从小到大排序。
 */
public class Interview24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(" ");
        int target = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] nums = new int[m];
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0;i < m;i++){
            nums[i] = scanner.nextInt();
            list.add(new Node(i,nums[i],Math.abs(nums[i]-target)));
        }
        list.sort((a,b)->{
            if(a.diff != b.diff)return a.diff - b.diff;
            else return a.i - b.i;
        });
        StringBuilder res = new StringBuilder();
        for(Node a:list) {
            res.append(a.val);
            res.append(" ");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
    static class Node{
        int i;
        int val;
        int diff;
        public Node(int i, int val, int diff) {
            this.i = i;
            this.val = val;
            this.diff = diff;
        }
    }
}
