package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
//记录简单的回溯问题
public class EasyBT {
    /**
     * 77 组合 看了4个小时答案没看懂。。。。。。。。。。。。最后问题出在
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *问题1：怎么处理path的更新？后置处理
     *问题2：为什么res.add(list)为空？因为list为同一个数据的引用，最后list被后置删了，所以都为空
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        //回溯法
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(n,k,1,list,res);
        return res;
    }
    private static void dfs(int n, int k,int index, ArrayList<Integer> list, ArrayList<List<Integer>> res) {
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        //i的取值范围
        for (int i = index; i <= n ; i++) {
            list.add(i);
            dfs(n,k,i+1,list,res);
            list.remove(list.size()-1);
        }
    }

    /**
     * 216 组合总和III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
     * 并且每种组合中不存在重复的数字。
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(k,n,1,list,res);
        return res;
    }
    private static void dfs(int k, int n,int start, List<Integer> list, List<List<Integer>> res) {
        if(n == 0 && k == 0){
            res.add(new ArrayList<>(list));

            return;
        }
        for (int i = start; i <= Math.min(n,9); i++) {
            list.add(i);
            dfs(k-1,n-i,i+1,list,res);
            list.remove(list.size()-1);
        }
    }

    /**
     * 17 电话号码的字母组合
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        Character[][] chars = new Character[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},
                {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        StringBuffer sb = new StringBuffer();
        dfs(digits,0,sb,res,chars);
        return res;
    }
    private static void dfs(String digits, int start, StringBuffer cur, ArrayList<String> res, Character[][] chars) {
        if(start == digits.length()){
            res.add(cur.toString());
            return;
        }
        char c = digits.charAt(start);
        for (int i = 0; i < chars[c-'2'].length; i++) {
            cur.append(chars[c-'2'][i]);
            dfs(digits,start+1,cur,res,chars);
            cur.delete(cur.length()-1,cur.length());
        }
    }

    /**
     * 39. 组合总和（加强剪枝问题）
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,candidates.length-1,target,list,res);
        return res;
    }
    private static void dfs(int[] candidates, int target,int start, int cur, List<Integer> list, ArrayList<List<Integer>> res) {
        if(cur == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(cur < 0)return;
        for (int i = start; i >=0; i--) {
            if(candidates[i]>cur){
                //list.add(candidates[i]);
                //相当于剪枝，如果传的是cur,会造成5-5-3这条枝多出来，与后序5-3重复
                dfs(candidates,target,i-1,cur-candidates[i],list,res);
                //list.remove(list.size() - 1);
            }else {
                list.add(candidates[i]);
                dfs(candidates, target, i, cur - candidates[i], list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 40. 组合总和 II(去重）
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        dfs1(candidates,target,0,used,list,res);
        return res;
    }
    private static void dfs1(int[] candidates, int target, int start, boolean[] used, List<Integer> list, ArrayList<List<Integer>> res) {
        if(target < 0)return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            //!used[i-1]表示 i-1位没有被使用，如果这样，那么i也不被使用
            if(i>0 && candidates[i-1] == candidates[i] && !used[i-1])continue;
            list.add(candidates[i]);
            used[i] = true;
            dfs1(candidates,target-candidates[i],i+1,used,list,res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }


    /**
     * 131. 分割回文串
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<List<String>> res = new ArrayList<>();
        dfs2(s,0,list,res);
        return res;
    }
    private void dfs2(String s, int start, ArrayList<String> list, ArrayList<List<String>> res) {
        //终止条件
        if(start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= s.length(); i++) {
            if(isPalin(s.substring(start,i))){
                list.add(s.substring(start,i));
                dfs2(s,i,list,res);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalin(String s) {
        if(s.length() == 0)return false;
        int left = 0,right = s.length()-1;
        while(left < right){
           if(s.charAt(left) == s.charAt(right)){
               left++;
               right--;
           }else{
               return false;
           }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{2,5,2,1,2};
        List<List<Integer>> lists = combinationSum2(ints, 5);
        for (List<Integer>  list:lists
        ) {
            for (int a :list
            ) {
                System.out.print(a+" ");
            }
            System.out.println();
        }

    }
}
