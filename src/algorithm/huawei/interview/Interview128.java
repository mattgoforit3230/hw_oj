package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 数组连续和
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间(包括单个正整数), 它们的和大于等于x。
 * 输入
 *  第一行两个整数N x(0 < N <= 100000, 0 <= x <= 10000000) 第二行有N个正整数(每个正整数小于等于100)。
 *  输出一个整数，表示所求的个数。
 *  注意:此题对效率有要求，暴力解法通过率不高，请考虑高效的实现方式。
 10 10000
 1 2 3 4 5 6 7 8 9 10
 =>0
 10 14
 1 2 3 4 5 6 7 8 9 10
=>35
 */
public class Interview128 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int res = 0;
        int sum = ints[0];
        for (int r = 0, l = 0; l < n && r < n;l++) {
            while(r < n-1 && sum < x){
                r++;
                sum+=ints[r];
            }
            if(sum >= x)res += n-r;
            sum -= ints[l];
        }
        System.out.println(res);

//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int x = s.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = s.nextInt();
//        }
//        int left = 0;
//        int right = 0;
//        long count = 0;
//        int sum = 0;
//        while (right < n) {
//            sum += nums[right];
//            while (sum >= x) {
//                if (sum >= x) {
//                    count += n - right;
//                }
//                sum -= nums[left];
//                left += 1;
//            }
//            right += 1;
//        }
//        System.out.println(count);
    }
}
