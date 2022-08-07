package algorithm.a_leecodeEveryday._again.backTracking;
import java.util.*;
public class Demo015 {
    private static boolean flag = true;

    public static void main(String[] args) {
        //[-1,0,1,2,-1,-4]0,0,0,0
        threeSum(new int[]{-1,0,1,0});
    }

    //三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(temp,res,0,0,nums,999);
        return res;
    }
    public static void dfs(List<Integer> temp,List<List<Integer>> res,int start,int need,int[] nums,int last){
        //第3个数sum,需要值为0
        if(temp.size() == 3 && need == 0 && start <= nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(temp.size() >= 3 || start >= nums.length)return;
        if(flag || (start>0 && nums[start]!= nums[start-1])) {

                temp.add(nums[start]);
                boolean temp_flag = flag;
                flag = true;
                dfs(temp, res, start + 1, need - nums[start], nums, nums[start]);
            /**
             * 测试
             */
//            for (int a : temp
//            ) {
//                System.out.print(a + " ");
//            }
//                System.out.println();

                temp.remove(temp.size() - 1);
                flag =temp_flag;

        }
        flag = false;
        dfs(temp,res,start+1,need,nums,last);
    }
}
