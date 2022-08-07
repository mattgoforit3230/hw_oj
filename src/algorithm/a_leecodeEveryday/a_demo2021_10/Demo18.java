package algorithm.a_leecodeEveryday.a_demo2021_10;
import java.util.*;

public class Demo18 {
    //18.四数之和
    public static void main(String[] args) {
        //[-471,-434,-418,-395,-360,-357,-351,-342,-317,-315,-313,-273,-272,-249,-240,-216,-215,-214,-209,-198,-179,-164,-161,-141,-139,-131,-103,-97,-81,-64,-55,-29,11,40,40,45,64,87,95,101,115,121,149,185,230,230,232,251,266,274,277,287,300,325,334,335,340,383,389,426,426,427,457,471,494]
        //2705
        List<List<Integer>> lists = fourSum(new int[]{-471,-434,-418,-395,-360,-357,-351,-342,-317,-315,-313,-273,-272,-249,-240,-216,-215,-214,-209,-198,-179,-164,-161,-141,-139,-131,-103,-97,-81,-64,-55,-29,11,40,40,45,64,87,95,101,115,121,149,185,230,230,232,251,266,274,277,287,300,325,334,335,340,383,389,426,426,427,457,471,494},
                2705);
        System.out.println(1);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        if(nums.length < 4)return res;
        List<Integer> list = new ArrayList<> ();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        dfs(nums,res,list,Integer.MAX_VALUE,-1,flag,0,4,target);
        return res;
    }
    public static void dfs(int[] nums,List<List<Integer>> res,List<Integer> list,int pre,int fnum,boolean[] flag,int start,int need,int sum) {
        if (need == 0 && sum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (start == nums.length || need < 0) return;
        if(nums[start] != pre || fnum ==-1 || (nums[start] == pre && flag[fnum] )){
            list.add(nums[start]);
            flag[start] = true;
            dfs(nums, res, list, nums[start], start,flag, start + 1, need - 1, sum - nums[start]);
            flag[start] = false;
            list.remove(list.size() - 1);
        }
        dfs(nums, res, list, nums[start], start,flag, start + 1, need, sum);
    }
}
