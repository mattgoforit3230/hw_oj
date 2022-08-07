package algorithm.a_leecodeEveryday.dp;

/**
 * 跳跃游戏2
 */
public class Dp1 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1,2,3}));
    }
    public static boolean canJump(int[] nums) {
        int steps = nums[0];
        for(int i = 1;i < nums.length-1 && i <= steps;i++){
            steps = Math.max(i + nums[i],steps);
        }
        return steps >= nums.length-1;
    }
}
