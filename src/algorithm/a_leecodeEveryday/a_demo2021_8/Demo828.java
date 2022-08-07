package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo828 {
    public static void main(String[] args) {
        int[] ints = runningSum(new int[]{1, 2, 3, 4, 5});
        for (int a :ints
             ) {
            System.out.print(a+" ");
        }
    }
    //1480. 一维数组的动态和
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]+= nums[i-1];
        }
        return nums;
    }
}
