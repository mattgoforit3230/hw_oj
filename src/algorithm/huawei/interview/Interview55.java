package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 一种字符串压缩表示的解压
 *有一种简易压缩算法:
 * 针对全部由小写英文字母组成的字符串
 * 将其中[连续超过两个]相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。
 * 例如:字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。
 * 请您编写解压函数，根据输入的字符串，判断其是否为合法压缩过的字符串，
 * 若输入合法则输出解压缩后的字符串，否则输出字符串“!error”来报告错误。
 */
public class Interview55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(fun(str));
    }

    private static String fun(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                if(i == n-1)return "!error";
                int temp = chars[i] - '0';
                if(temp == 0 && num == 0)return "!error";
                num = num * 10 + temp;
            }else if(chars[i] >= 'a' && chars[i] <= 'z'){
                if(num != 0){
                    if(num == 2)return "!error";
                    for (int j = 0; j < num; j++) {
                        sb.append(chars[i]);
                    }
                    num = 0;
                }else{
                    sb.append(chars[i]);
                }
            }else{
                return "!error";
            }
        }
        return sb.toString();
    }
}
