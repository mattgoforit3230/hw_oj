package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 滑动窗口最大值
 */
public class Interview15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        int N = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[N];
        String s = scanner.nextLine();
        String[] split = s.split("\\s+");
        for(int i = 0;i < N;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        int M = Integer.parseInt(scanner.nextLine());
        int pre = 0;
        for(int i = 0;i < M;i++)pre += nums[i];
        int j = 0,res = pre;
        for(int i = M;i < N;i++){
            res = Math.max(res,pre - nums[j] + nums[i]);
            pre = pre - nums[j] + nums[i];
            j++;
        }
        System.out.println(res);
    }
}
