package algorithm.a_leecodeEveryday._again.backTracking;
import java.util.*;

public class Demo90 {
    //90递增子序列
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,curr,nums,0,-11);
        return res;
    }

    private static void dfs(ArrayList<List<Integer>> res, ArrayList<Integer> curr,int[] nums, int start,int last) {
        if(start>=nums.length)return;
//        res.add(new ArrayList<>(curr));

            curr.add(nums[start]);
        res.add(new ArrayList<>(curr));
            dfs(res,curr,nums,start+1,nums[start]);
            curr.remove(curr.size()-1);

        if(last != nums[start])dfs(res,curr,nums,start+1,last);
    }
}
