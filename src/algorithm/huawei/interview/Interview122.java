package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ABR ⻋路协同场景
 * 数轴×有两个点的序列 A={A1， A2,...Am}和 B={B1,B2,.Bn}， A 和 Bj 均为正整数， A、 B 已经从小 到大排好序， A、 B 均肯定不为空，
 * 给定一个距离 R(正整数)，列出同时满足如下条件的所有(Ai， Bj)数对:
 * 条件
 * 1) Ai <= Bj
 * 2) Ai,Bj 距离小于等于 R，但如果 Ai 找不到 R 范围内的 Bj，则列出距它最近的 1 个 Bj，当然此种情 况仍然要满足 1，
 * 但如果仍然找不到，就丢弃 Ai。
 *
 A={1,3,5},B={2,4,6},R=1
 =>(1,2)(3,4)(5,6)

 A={1,2,3,5},B={1,2,3,4,6,9},R=2
 */
public class Interview122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int a = 0,b = 0,r = 0;
        int R = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(cur == 'A'){
                a = i;
            }else if(cur == 'B'){
                b = i;
            }else if(cur == 'R'){
                r = i;
                R = Integer.parseInt(str.substring(i+2));
            }
        }
        String sA = str.substring(a+3,b-2);
        String sB = str.substring(b+3,r-2);
        int[] A = Arrays.stream(sA.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(sB.split(",")).mapToInt(Integer::parseInt).toArray();
        //int start = 0;
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            //int cur = A[i];
            int start = -1;
            for (int j = 0; j < B.length; j++) {
                if(B[j] - A[i] >= 0){
                    if(start == -1)start = j;
                    if(B[j] - A[i] <= R || j == start){
                        res.add(new int[]{A[i],B[j]});
                    }else{
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] temp:res){
            sb.append("(");
            sb.append(temp[0]);
            sb.append(",");
            sb.append(temp[1]);
            sb.append(")");
        }
        System.out.println(sb);
    }
}
