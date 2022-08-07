package algorithm.huawei.childrensDay_eve;

import java.util.Scanner;

/**
nums = {1,4,2,5,5,1,6} cnt=13 =>2
 nums = {1,3,2,1} cnt=197 =>-1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(manageTourists(new int[]{1,4,2,5,5,1,6},15));
    }
    public static int manageTourists(int[] nums,int cnt){
        int max = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            sum += nums[i];
        }
        if(sum <= cnt)return -1;
        int l = 0,r = max;
        while(l < r){
            int m = l + r >> 1;
            if(check(m,nums,cnt)){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l-1;
    }

    private static boolean check(int m, int[] nums, int cnt) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.min(m,nums[i]);
        }
        return sum <= cnt;
    }
}
