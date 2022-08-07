package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 第K个排列
 *  给定参数n，从1到n会有n个整数:1,2,3,...,n,这n个数字共有n!种排列。
 *  按大小顺序升序列出所有排列的情况，并一一标记，
 *  当n=3时,所有排列如下:
 * "123" "132" "213" "231" "312" "321"
 * 给定n和k，返回第k个排列。
 * 输入
 *  输入两行，第一行为n，第二行为k， 给定n的范围是[1,9],给定k的范围是[1,n!]。
 *  输出
 *  输出排在第k位置的数字。
 *  "123" "132" "213" "231" "312" "321" =>

 9
 546
 =>123867954
 8
 23553
 =>56723418
 */
public class Interview79 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int k = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<String> list = new ArrayList<>();
        boolean[] isUsed = new boolean[n + 1];
        dfs(isUsed,list,new StringBuilder(),1,n);
        list.sort((a,b)->{
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i))return a.charAt(i) - b.charAt(i);
            }
            return -1;
        });
        System.out.println(list.get(k-1));

    }

    private static void dfs(boolean[] isUsed,
                            ArrayList<String> list, StringBuilder sb, int cur, int n) {
        if(sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for(int i = 1;i <= n;i++){
            if(isUsed[i])continue;
            sb.append(i);
            isUsed[i] = true;
            dfs(isUsed,list,sb,i+1,n);
            sb.deleteCharAt(sb.length()-1);
            isUsed[i] = false;
        }
    }
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        List<Integer> list = new ArrayList<>();
//        int[] arr = new int[n + 1];
//        arr[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//            arr[i] = arr[i - 1] * i;
//        }
//        k--;
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = n - 1; i >= 0; i--) {
    // 计算候选数字的index
//            int index = k / arr[i];
//            stringBuffer.append(list.remove(index));
//            k -= index * arr[i];
//        }
//        System.out.println(stringBuffer.toString());
 //   }
}
