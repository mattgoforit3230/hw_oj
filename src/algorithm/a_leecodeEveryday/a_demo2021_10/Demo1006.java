package algorithm.a_leecodeEveryday.a_demo2021_10;
import java.util.*;

public class Demo1006 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(8));
        int[] arr = new int[]{1,2};

    }
    public static int thirdMax(int[] nums) {
        long[] ints = new long[3];
        Arrays.fill(ints,Integer.MIN_VALUE);
        for(int i = 0;i < nums.length;i++){
            int k = 2;
            while(k >= 0){
                if(ints[k] == nums[i]){
                    k = -2;
                    break;
                }
                if(ints[k] > nums[i])break;
                k--;
            }
            switch(k){
                case -2:
                    break;
                case 2:
                    break;
                case -1:
                    ints[2] = ints[1];
                    ints[1] = ints[0];
                    ints[0] = nums[i];
                    break;
                case 0:
                    ints[2] = ints[1];
                    ints[1] = nums[i];
                case 1:
                    ints[2] = nums[i];
            }
        }
        return (int) (ints[2]<Integer.MIN_VALUE?ints[0]:ints[2]);
    }
}
