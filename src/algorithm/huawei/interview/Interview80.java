package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 非严格递增连续数字序列
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最⻓的非严格递增连续数字序列的⻓度
 * (比如12234属于非严格递增连续数字序列)。
 *
 * 输入
 * 输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
 * 输出
 * 最⻓的非严格递增连续数字序列的⻓度
 *
 abc2234019A334bc
 =》 4

 */
public class Interview80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int pre = 0,res = 0;
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            pre = 1;
            res = 1;
        }
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(cur >= '0' && cur <= '9'){
                if(str.charAt(i-1) >= '0' &&
                        str.charAt(i-1)<= '9' && str.charAt(i-1) <= cur){
                    pre++;
                }else{
                    pre = 1;
                }
            }else{
                pre = 0;
            }
            res = Math.max(res,pre);
        }
        System.out.println(res);
    }
}
