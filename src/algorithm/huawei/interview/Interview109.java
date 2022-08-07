package algorithm.huawei.interview;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 全排列
 *  给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
 *  如:S为ABA，则不同的排列有ABA、AAB、BAA三种。
 *
 *  输入一个⻓度不超过10的字符串S，我们确保都是大写的。
 *
 *  输出S重新排列的所有不相同的排列数(包含自己本身)。
 *
 ABA
 =>3
 ABCDEFGHHA
 =>907200
 */
public class Interview109 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        boolean[] isUsed = new boolean[str.length()];
        dfs(str,0,isUsed);
        System.out.println(res);
    }
    public static void dfs(String s,int sum,boolean[] isUsed){
        if(sum == s.length()){
            res++;
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (isUsed[i] || set.contains(s.charAt(i))) continue;
            sum++;
            set.add(s.charAt(i));
            isUsed[i] = true;
            dfs(s, sum, isUsed);
            isUsed[i] = false;
            sum--;
        }
    }
}
