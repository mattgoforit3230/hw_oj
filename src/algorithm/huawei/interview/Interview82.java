package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 密钥格式化
 * 给定一个非空字符串 S，其被 N 个'-'分隔成 N+1 的子串，
 * 给定正整数 K，要求除第一个子串外，其余 的串每 K 个用'-'分隔，并将小写字母转换为大写。
 *
 *输入
 *  S = "5F3Z-2e-9-w" K =4
 * 输出
 * "5F3Z-2E9W"
 *
 2
 25G3C-abc-d
 */
public class Interview82 {
    public static void main(String[] args) {
        //System.out.println((char)('a' - 32));
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine().trim());
        String str = scanner.nextLine().trim();
        int temp = K;
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            char cur = str.charAt(i);
            if(cur >= '0' && cur <= '9'){
                temp--;
                res.append(cur);
            }else if(cur >= 'A' && cur <= 'Z'){
                temp--;
                res.append(cur);
            }else if(cur >= 'a' && cur <= 'z'){
                temp--;
                cur = (char)(cur - 32);
                res.append(cur);
            }
            if(temp == 0){
                res.append("-");
                temp = K;
            }
        }
        if(res.charAt(res.length()-1) == '-')res.deleteCharAt(res.length()-1);
        System.out.println(res.reverse());
    }
}
