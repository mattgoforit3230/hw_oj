package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
public class Demo055 {
    //跳跃游戏
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,0,8,2,0}));
    }
    public static boolean canJump(int[] nums) {
        return dfs(nums,0,nums[0]);
    }
    public static boolean dfs(int[] nums,int start,int path) {
        if (path >= nums.length - 1) return true;
        if (start == nums.length || (nums[start] == 0 && path == start)) return false;
        path = Math.max(path, start + nums[start]);

        if (dfs(nums, start + 1, path)) return true;
        return false;
    }
}
