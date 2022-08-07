package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 32 字符串序列判定
 * 输入两个字符串S和L，都只包含英文小写字母。S⻓度<=100，L⻓度<=500,000。 判定S是否是L的有效子串。
 * S中的每个字符在L中都能找到(可以不连续)，且S在L中字符的前后顺序与S中顺序要保持一致。
 * (例如，S="ace"是L="abcde"的一个子序列且有效字符是a、c、e，而"aec"不是有效子序列，且有效 字符只有a、e)
 */
public class Interview32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String l = scanner.nextLine().trim();
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for(int j = pre+1;j < l.length();j++){
                if(l.charAt(j) == s.charAt(i)){
                    flag = true;
                    pre = j;
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(pre);
    }
}
