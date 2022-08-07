package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 连续字母⻓度
 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，⻓度第 k ⻓的子串的⻓度，相 同字母只取最⻓的那个子串。
 */
public class Interview1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int N = scanner.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        int temp = 1;
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(i == s.length()-1 || cur!=s.charAt(i+1)){
                if(!map.containsKey(cur) || map.get(cur)<temp){
                    map.put(cur,temp);
                    temp = 1;
                }
            }else{
                temp++;
            }
        }
        if(map.size() < N) {
            System.out.println(-1);
        }else{
            int i = 0;
            Integer[] ints = new Integer[map.size()];
            for (Map.Entry<Character,Integer> entry:
                    map.entrySet()) {
                ints[i++] = entry.getValue();
            }
            Arrays.sort(ints,(a,b)->b-a);
            System.out.println(ints[N-1]);
        }
    }
}
