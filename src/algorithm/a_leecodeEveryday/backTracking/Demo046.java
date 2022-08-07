package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
public class Demo046 {
    //46. 全排列

    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums,list,res,used);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, ArrayList<List<Integer>> res,boolean[] used) {
        if(list.size() == nums.length){
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i])continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums,list,res,used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
