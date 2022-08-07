package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大时间
 * 给定一个数组，里面有 6 个整数，
 * 求这个数组能够表示的最大 24 进制的时间是多少，输出这个时间，无法表示输出 invalid。
 *
 [0,2,3,0,5,6]
 =>23:56:00
 */
public class Interview69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(",");
        int[] nums = Arrays.stream(split).mapToInt(Integer::parseInt).sorted().toArray();
        //Arrays.sort(nums,());基本数据类型不能用comparator
        int[] res = new int[6];
        fun(nums,res,0,2);
        if(res[0] == 2){
            fun(nums,res,1,3);
        }else{
            fun(nums,res,1,9);
        }
        fun(nums,res,2,5);
        fun(nums,res,3,9);
        fun(nums,res,4,5);
        fun(nums,res,5,9);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if(res[i] < 0){
                System.out.println("invalid");
                return;
            }
            sb.append(res[i]);
            if(i == 1 || i == 3)sb.append(":");
        }
        System.out.println(sb);
    }

    private static void fun(int[] nums, int[] res, int i, int max) {
        for (int j = nums.length-1; j >= 0; j--) {
            if(nums[j] <= max && nums[j] != -1){
                res[i] = nums[j];
                nums[j] = -1;
                break;
            }
        }
    }
}
