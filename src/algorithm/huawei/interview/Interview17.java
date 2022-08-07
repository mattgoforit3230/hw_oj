package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 【最少交换次数】
 * 2022年05月09日 17:50
 *    【编程题目 |100分】最少交换次数【2022 Q1 考试题】
 *   时间限制:C/C++ 1秒，其他语言 2秒 空间限制:C/C++262144K，其他语言524288K 64bit IO Format:%lld
 * 本题可使用本地IDE编码，不能使用本地已有代码，无跳出限制， 编码后请点击"保存并调试"按钮进行代码提交。
 *     给出一个二进制数组nums，你需要通过交换位置，将数组中 任何位置 上的 小于k的整数 组合到 一起，
 *     并返回所有可能中所需最少的交换次数。 输出将数组A中小于k的整数组合到一起的最小交换次数。
 *     组合在一起是指满足条件的数字相邻， 不要求相邻后在数组中的位置。
 *
 *
 *     ==>翻译：一个长度为【小于k的数的个数】的滑窗，中间大于k的数的最少个数
 */
public class Interview17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        System.out.println(minSwap(new int[]{1,20,1,20,1},100));

    }
    public static int minSwap(int[] nums, int k){
        int len = 0,upper = 0;
        for(int a:nums)if(a < k)len++;
        for(int i = 0;i < len;i++){
            if(nums[i] >= k)upper++;
        }
        int res = upper;
        for(int l = 1,r = len;r < nums.length;r++,l++){
            if(nums[r] < k && nums[l-1] >= k)upper--;
            else if(nums[r] >= k && nums[l-1] < k)upper++;

            res = Math.min(res,upper);
        }
        return res;
    }
}
