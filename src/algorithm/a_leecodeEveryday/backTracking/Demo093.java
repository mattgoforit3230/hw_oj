package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
public class Demo093 {
    public static void main(String[] args) {
        restoreIpAddresses("25111");
    }
    //93. 复原 IP 地址
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfs(s,0,curr,res,2);
        return res;
    }
    private static void dfs(String s, int start, List<String> curr,List<String> res,int limit) {
        if(start >= s.length() && limit==0){
            res.add(String.join(".", curr));
            return;
        }
        if(start<s.length() && limit == 0)return;
        for (int i = start+1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            int i1 = Integer.parseInt(substring);
            if(substring.length()!=1 && substring.substring(0,1)=="0")return;
            if(i1>=0 && i1<=255){
                curr.add(substring);
                limit--;
                dfs(s,i,curr,res,limit);
                res.remove(res.size()-1);
                limit++;
            }else{
                return;
            }
        }
    }
}
