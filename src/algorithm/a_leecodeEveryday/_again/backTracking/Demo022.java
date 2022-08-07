package algorithm.a_leecodeEveryday._again.backTracking;
import java.util.*;
public class Demo022 {
    //22. 括号生成
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int left=n,right = n;
        dfs(res,sb,left,right,0);
        return res;
    }

    private void dfs(ArrayList<String> res, StringBuffer sb, int left, int right,int index) {
        if(left==0 && right == 0){
            res.add(sb.toString());
        }
        if(index < 0)return;
        if(left > 0){

            sb.append("(");
            dfs(res,sb,left-1,right,index+1);
            sb.delete(sb.length()-1,sb.length());

        }
        if(right > 0){

            sb.append(")");
            dfs(res,sb,left,right-1,index-1);
            sb.delete(sb.length()-1,sb.length());

        }
    }
}
