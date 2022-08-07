package algorithm.a_leecodeEveryday.slidingwindow;

public class Demo567 {
    //567. 字符串的排列,即s1是否为s2的字串
    public boolean checkInclusion(String s1, String s2) {
        //滑动窗口
        //方法一：
//        int n = s1.length();
//        int[] ints = new int[26];
//        for (int i = 0; i < n; i++) {
//            --ints[s1.charAt(i)];
//            ++ints[s2.charAt(i)];
//        }
//        int diff = 0;
//        for (int i = 0; i < ints.length; i++) {
//            if(ints[i] != 0)diff++;
//        }
//        if(diff == 0)return true;
//        for (int i = n; i < s2.length(); i++) {
//            int x = s2.charAt(i) - 'a',y = s2.charAt(i - n) - 'a';
//            if(x == y)continue;
//            if(ints[x] == 0)diff++;
//            ints[x]++;
//            if(ints[x] == 0)diff--;
//
//            if(ints[y] == 0)diff--;
//            ints[y]--;
//            if(ints[y] == 0)diff++;
//
//            if(diff==0)return true;
//        }
//        return false;
        int n = s1.length();
        if(s2.length() < n)return false;
        int[] ints = new int[26];
        for (int i = 0; i < n; i++) {
            --ints[s1.charAt(i) - 'a'];
        }
        int left  = 0;
        for (int i = 0; i < s2.length(); i++) {
            ints[s1.charAt(i) - 'a']++;
            while(ints[s1.charAt(i) - 'a'] > 0){
                //左指针
                ints[s1.charAt(left) - 'a']--;
                left++;
            }
            if(i-left+1 == n)return true;
        }
        return false;
    }
}
