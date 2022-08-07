package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 用连续自然数之和来表达整数
 *一个目标整数T (1 <=T<= 1000)
 * 自然数个数最少的表达式优先输出
 * 每个表达式中按自然数递增的顺序输出
 * 在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数
 *
 9 =》
 9=9
 9=4+5
 9=2+3+4
 Result:3
 */
public class Interview53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<int[]> list = new ArrayList<>();
        int sum = 0;
        for (int r = 1,l = 1; r <= target; r++) {
            sum += r;
            while(sum > target){
                sum -= l;
                l++;
            }
            if(sum == target){
                int[] temp = new int[r - l + 1];
                int k = 0;
                for (int i = l; i <= r; i++) {
                    temp[k++] = i;
                }
                list.add(temp);
            }
        }
        list.sort((a,b)->a.length - b.length);
        int result = list.size();
        for(int[] temp : list){
            StringBuilder sb = new StringBuilder();
            sb.append(target+"=");
            for(int i :temp) {
                sb.append(i);
                sb.append("+");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }
        System.out.println("Result:"+result);
    }
}
