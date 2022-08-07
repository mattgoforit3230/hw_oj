package algorithm.a_leecodeEveryday.dp;

public class Demo0213 {
    public static void main(String[] args) {
        //[200,3,140,20,10]
        System.out.println(rob(new int[]{200,3,140,20,10}));
    }
    //213. 打家劫舍 II
    public static int rob(int[] nums) {
        int first_1 = nums[0],second_1 = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length-1;i++){
            int temp = second_1;
            second_1 = Math.max(nums[i]+first_1,second_1);
            first_1 = second_1;
        }
        int first_2 = nums[1],second_2 = Math.max(nums[2],nums[1]);
        for(int i = 3;i < nums.length;i++){
            int temp = second_2;
            second_2 = Math.max(nums[i]+first_2,second_2);
            first_2 = second_2;
        }
        return Math.max(second_1,second_2);
    }
}
