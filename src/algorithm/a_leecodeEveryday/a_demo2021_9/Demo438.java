package algorithm.a_leecodeEveryday.a_demo2021_9;
import java.util.*;
public class Demo438 {
    //438. 找到字符串中所有字母异位词
    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        //"cbaebabacd"
        //"abc"
        //滑动窗口 p子串
        ArrayList<Integer> res = new ArrayList<>();
        int n = p.length();
        if(n > s.length())return res;
        int[] ints = new int[26];
        for (int i = 0; i < n; i++) {
            --ints[p.charAt(i) - 'a'];
        }

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)-'a']++;
            while(ints[s.charAt(i)-'a'] > 0){
                ints[s.charAt(left)-'a']--;
                left++;
            }
            if(i-left+1 == n)res.add(left);
        }
        return res;
    }
}
