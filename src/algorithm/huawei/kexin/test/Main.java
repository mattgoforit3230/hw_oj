package algorithm.huawei.kexin.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            res += nums[i];
            list.add(nums[i]);
            if(res + res > sum)return list;
        }
        return list;
    }
}
