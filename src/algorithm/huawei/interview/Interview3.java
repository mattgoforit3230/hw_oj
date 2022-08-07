package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Interview3 {
    public static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        String s = scanner.nextLine();
        String[] splits = s.split("\\s+");
        for(int i = 0;i < 10;i++){
            nums[i] = Integer.parseInt(splits[i]);
        }
        int sum = Arrays.stream(nums).sum();
        dfs(nums,sum,0,0);
        System.out.println(res);
    }

    private static void dfs(int[] nums, int sum, int start, int cur) {
        res = Math.min(res,Math.abs(sum - cur - cur));
        if(start == nums.length)return;
        dfs(nums,sum,start+1,cur);
        dfs(nums,sum,start+1,cur+nums[start]);
    }

}
