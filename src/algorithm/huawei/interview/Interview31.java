package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * [31 最大N个数与最小N个数的和]
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * 说明:
 * 数组中数字范围[0, 1000] 最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1 输入非法返回-1
 * 输入描述:
 * 第一行输入M， M标识数组大小 第二行输入M个数，标识数组内容 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述:
 * 输出最大N个数与最小N个数的和。
 * 5
 * 3 2 3 4 2
 */
public class Interview31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        TreeSet<Integer> set = new TreeSet<>();
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        for(int i = 0;i < N;i++){
            set.add(Integer.parseInt(split[i]));
        }
        int n = set.size();
        int k = Integer.parseInt(scanner.nextLine().trim());
        if(2 * k > n){
            System.out.println(-1);
        }else {
            int res = 0;
            ArrayList<Integer> list = new ArrayList<>(set);
            for (int i = 0; i < k;i++){
                res += list.get(i);
                res += list.get(n-i-1);
            }
            System.out.println(res);
        }
    }
}
