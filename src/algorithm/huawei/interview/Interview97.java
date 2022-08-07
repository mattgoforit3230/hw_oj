package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 高矮个子排队
 *  现在有一队小朋友，他们高矮不同，我们以正整数数组表示这一队小朋友的身高，如数组 {5,3,1,2,3}。
 * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，每一个“高”位置的小朋友要比相邻的位置高或者相等;每一个“矮”位置的小朋友要比相邻的位置矮或者相等;
 * 要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
 4 1 3 5 2
 =>4 1 5 2 3  why not   4 1 3 2 5
 */
public class Interview97 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split("\\s+");
        int n = split.length;
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            if((i & 1) == 0 && i != n-1 && ints[i] < ints[i + 1]){
                int temp = ints[i];
                ints[i] = ints[i+1];
                ints[i+1] = temp;
            }else if((i & 1) != 0 && i != n-1 && ints[i] > ints[i + 1]){
                int temp = ints[i];
                ints[i] = ints[i+1];
                ints[i+1] = temp;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int a:ints){
            res.append(a);
            res.append(" ");
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
