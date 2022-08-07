package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 检查是否存在满足条件的数字组合
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合 规则:A = B + 2C
 *
 *  如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 *  如果不存在，输出0。
 4
 2 7 3 0
 => 7 3 2
3
 1 1 1
 =>0
 */
public class Interview112 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] split = scanner.nextLine().trim().split("\\s+");
        int[] nums = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        fun(nums);
    }
    public static void fun(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j)continue;
                int target = nums[i] + 2*nums[j];
                if(target > nums[n-1])break;
                int max = Math.max(i,j);
                for (int k = max+1; k < n; k++) {
                    if(nums[k] == target){
                        System.out.println(nums[k] +" "+nums[i]+" "+nums[j]);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
