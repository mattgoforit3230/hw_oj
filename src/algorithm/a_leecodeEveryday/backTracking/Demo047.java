package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;

public class Demo047 {
    public static void main(String[] args) {
        //System.out.println(permuteUnique(new int[]{1,2,3}));
    }
    //47. 全排列 II
    public  List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
        HashSet<Integer> exist = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums,list,res,used);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, ArrayList<List<Integer>> res,boolean[] used) {
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        HashSet<Integer> exist = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if(exist.contains(nums[i]))continue;
            if(used[i])continue;
            exist.add(nums[i]);

            list.add(nums[i]);
            used[i] = true;
            dfs(nums,list,res,used);
            list.remove(list.size()-1);
            used[i] = false;
            exist.remove(nums[i]);
        }
    }
}
