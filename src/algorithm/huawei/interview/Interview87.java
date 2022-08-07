package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字涂色
 *  疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。
 *  黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。
 * 为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数
 * 整除。
 * 现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 *
 *  第一行有一个正整数N，其中。
 *  第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 *
 3
 2 4 6
 => 1
 4
 2 3 4 9
 => 2
 */
public class Interview87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        boolean[] s = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i]) {
                continue;
            } else {
                for (int j = i; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        s[j] = true;
                    }
                }
                res++;
            }
        }
        System.out.println(res);
    }
}
