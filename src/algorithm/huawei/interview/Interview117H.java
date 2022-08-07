package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串匹配
 *  第一行输入一串以空格分隔的字符串 第二行输入一个匹配字符串("."代表单个任意字符，"*"代表0个或多个字符)
 * 输出每个以空格分隔的字符串是否与匹配字符串相匹配，匹配的话输出它的下标，不匹配则不输出。
 *
 ab abc bsd
 .*
 =>0,1,2
 avd adb sss as
 adb
 =>1
 abba
 .*
 */
public class Interview117H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split("\\s+");
        String p = scanner.nextLine().trim();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(isMatch(split[i],p))list.add(i+"");
        }
        System.out.println(String.join(",",list));
    }
    public static boolean isMatch(String s, String p) {
        s = " "+s;
        p = " "+p;
        int n = s.length(),m = p.length();
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        if(s.charAt(1) == p.charAt(1) || p.charAt(1) == '.')dp[1][1] = true;
        for(int i = 0;i < n;i++){
            for(int j = 1;j < m;j++){
                if(p.charAt(j) == '*'){
                    //需要i从0开始，因为s= “”,p = "a*"也是匹配的dp[0][2] = true
                    if(i > 0)dp[i][j] = dp[i][j-2] ||
                            dp[i-1][j]&&(p.charAt(j-1) == s.charAt(i) ||
                                    p.charAt(j-1) == '.');
                    else dp[i][j] = dp[i][j-2];
                }else{
                    if(i > 0)dp[i][j] = (p.charAt(j) == s.charAt(i) ||
                            p.charAt(j) == '.') && dp[i-1][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
