package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 编程题目 | 200分】最大出牌数量 [ 2022 Q1考试题 ]
 * 手里给一副手牌，数字从0-9，有r(红色),，g(绿色)，b(蓝色)，y(⻩色)四种颜色，
 * 出牌规则为每 次打出的牌必须跟上一张的数字或者颜色相同，否则不能抽选。
 * 选手应该怎么选才能使得抽选的次数最大，并且输出这个最大次数。
 * 输入描述
 * 第一行 牌的数值n (1<=n<=9)
 * 第二行 牌的颜色(r,g,b,y四种颜色表示)
 * 输出描述
 *
 * 输出最大出牌数量
 1 4 3 4 5
 r y b b r
 ==> 3
 */
public class Interview6H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String a = scanner.nextLine();
        String[] splits1 = s.split("\\s+");
        String[] splits2 = a.split("\\s+");
        int n = splits1.length;
        int[] nums = new int[n];
        char[] chars = new char[n];
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(splits1[i]);
            chars[i] = splits2[i].charAt(0);
        }
        int[][] arr = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(nums[i] == nums[j] || chars[i] == chars[j]){
                    arr[i][j] = 1;
                }
            }
        }
        boolean[] flag = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int res = 0;
        for(int i = 0;i < n;i++){
            if(!flag[i]){
                flag[i] = true;
                queue.add(i);
            }else{
                continue;
            }
            int temp = 0;
            while(!queue.isEmpty()){
                int p = queue.poll();
                temp++;
                for(int j = 0; j < n;j++){
                    if(arr[j][p] == 1 && !flag[j] && j!=p){
                        queue.add(j);
                        flag[j] = true;
                    }
                }
            }
            res = Math.max(res,temp);
        }
        System.out.println(res);
    }
}

