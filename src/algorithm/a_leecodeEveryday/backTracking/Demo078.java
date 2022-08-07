package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
public class Demo078 {
    //78.子集
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        dfs(res,curr,nums,0);
        return res;
    }

    private void dfs(ArrayList<List<Integer>> res, ArrayList<Integer> curr,int[] nums, int start) {
        if(start>nums.length)return;
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(res,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
