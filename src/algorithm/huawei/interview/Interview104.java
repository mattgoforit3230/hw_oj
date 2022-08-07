package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 求符合要求的结对方式
 *  用一个数组A代表程序员的工作能力，公司想通过结对编程的方式提高员工的能力，
 *  假设结对后的 能力为两个员工的能力之和，求一共有多少种结对方式使结对后能力为N。
 10
 4 4 2 6 6 2 3 3 4 4
 8
 =>10
4
 1 1 2 2
 3

 */
public class Interview104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String str = scanner.nextLine().trim();
        int target = Integer.parseInt(scanner.nextLine().trim());
        int[] staff = Arrays.stream(str.split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(staff[i])){
                res += map.get(staff[i]);
            }
            map.put(target - staff[i],
                    map.getOrDefault(target - staff[i],0) + 1);
        }
        System.out.println(res);
    }
}
