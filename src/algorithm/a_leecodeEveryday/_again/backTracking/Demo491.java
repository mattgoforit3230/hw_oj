package algorithm.a_leecodeEveryday._again.backTracking;
import java.util.*;
public class Demo491 {
    public static void main(String[] args) {
        findSubsequences(new int[]{0,0,0,0});
    }
    //491. 递增子序列

    /**
     * 经典疑问：怎么剪枝，比如44677，怎么吧4和7重复的删掉，
     * 设置map标识，前一个4没有加，下一个也不管✖️不是顺序
     * 去掉for
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if(nums.length==0)return res;
        dfs(nums,res,curr,0,-101);
        return res;
    }
    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr,
                            int start,int bef) {
        if(start == nums.length){
            if(curr.size()>=2){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        if(nums[start] >= bef){
            curr.add(nums[start]);
            dfs(nums,res,curr,start+1,nums[start]);
            curr.remove(curr.size()-1);
        }
        if(nums[start]!=bef) dfs(nums,res,curr,start+1,bef);
    }
}
