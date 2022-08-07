package algorithm.a_leecodeEveryday.dp;

public class Demo005 {
    //5. 最长回文子串
    public String longestPalindrome(String s) {
        //dp[i]为到i之前最长到回文数
        if(s.length()==1)return s;
        if(s.length() == 2)return s.substring(0,1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int max_length = 0;
        int max_left = 0;
        int max_right = 0;
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if(s.charAt(r) == s.charAt(l) && ( r-l<=2 || dp[l+1][l-1])){
                    dp[l][r] = true;
                    if(r-l+1 > max_length){
                        max_left = l;
                        max_right = r;
                        max_length = r-l+1;
                    }
                }
            }
        }
        return s.substring(max_left,max_right+1);
    }
}
