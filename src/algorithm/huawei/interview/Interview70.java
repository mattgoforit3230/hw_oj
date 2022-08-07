package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 拼接URL
 *  给定一个URL前缀和URL后缀，通过","分割，需要将其连接为一个完整的URL，
 *  如果前缀结尾和后缀开头都没有“/”，需自动补上“/”连接符，如果前缀结尾和后缀开头都为“/”，需自动去重。
 *  约束:不用考虑前后缀URL不合法情况。
 *输入描述
 *  URL前缀(一个⻓度小于100的字符串)，URL后缀(一个⻓度小于100的字符串)。
 *输出描述
 *  拼接后的URL。
 *
 /acm,/bb
 =》 /acm/bb

 /abc/,/bcd
 =》 /abc/bcd

 ,
 -》 /
 */
public class Interview70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        str = str.replace(",","/");
        str = str.replace("///","/");
        str = str.replace("//","/");
        System.out.println(str);
    }
}
