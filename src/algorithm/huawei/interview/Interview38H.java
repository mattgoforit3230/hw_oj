package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 38 N进制减法
 * 主管期望你实现一个基于字符串的N机制的减法。
 * 需要对输入的两个字符串按照给定的N进制进行减法操作，输出正负符号和表示结果的字符串。
 * 第一个参数是整数形式的进制N值，N值范围为大于等于2、小于等于35。
 * 第二个参数为被减数字符串;
 * 第三个参数为减数字符串。
 *
 * 有效的字符包括0-9以及小写字母a-z，字符串有效字符个数最大为100个字符，另外还有结尾的\0。
 * 限制:
 * 输入的被减数和减数，除了单独的0以外，不能是以0开头的字符串。
 * 如果输入有异常或计算过程中有异常，此时应当输出-1表示错误。
 * 【几个问题】：
 * 1。减法需要提前知道确定较大的数作为被减数
 * 2。n进制需要判读是否大于10，转字符
 * 3。高位被减掉后，需要去除0；
 */
public class Interview38H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = s.split("\\s+");
        int scale = Integer.parseInt(split[0]);
        String a = split[1],b = split[2];
        //判断数字是否超出进制
        for(int i = 0;i < a.length();i++){
            if(a.charAt(i) >= 'a' && a.charAt(i)-'a'+10 >= scale){
                System.out.println(-1);
                return;
            }
            if(a.charAt(i) < 'a' && a.charAt(i)-'0' >= scale){
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0;i < b.length();i++){
            if(b.charAt(i) >= 'a' && b.charAt(i)-'a'+10 >= scale){
                System.out.println(-1);
                return;
            }
            if(b.charAt(i) < 'a' && b.charAt(i)-'0' >= scale){
                System.out.println(-1);
                return;
            }
        }
        if(a.length() != 1 && a.charAt(0)=='0' ||
                b.length() != 1 && b.charAt(0)=='0'){
            System.out.println(-1);
        }else {
            //StringBuilder sb = new StringBuilder();
            if (a.length() != b.length()) {
                if (a.length() > b.length()) {
                    System.out.println("0 "+fun(scale,a,b));
                }else{
                    System.out.println("1 "+fun(scale,b,a));
                }
            } else {
                if (a.compareTo(b) < 0){
                    System.out.println("1 "+fun(scale,b,a));
                }else{
                    System.out.println("0 "+fun(scale,a,b));
                }
            }
        }
    }
    private static String fun(int scale, String a, String b) {
        int n = a.length(), m = b.length();
        int ca = 0,i = n-1,j = m-1;
        StringBuilder res = new StringBuilder();
        while(ca != 0 || i >= 0 || j >= 0){
            if(i >= 0) {
                if(a.charAt(i) >='a' && a.charAt(i) <= 'z'){
                    ca += a.charAt(i) -'a' + 10;
                }else{
                    ca += a.charAt(i) -'0';
                }
                i--;
            }
            if(j >= 0) {
                if(b.charAt(j) >='a' && b.charAt(j) <= 'z'){
                    ca -= b.charAt(j) -'a' + 10;
                }else{
                    ca -= b.charAt(j) -'0';
                }
                j--;
            }
            if(ca < 0){
                if(scale + ca >= 10){
                    char cur = (char)(scale + ca - 10 +'a');
                    res.append(cur);
                }else{
                    res.append(scale + ca);
                }
                ca = -1;
            }else{
                if(ca >= 10){
                    char cur = (char)(ca - 10 +'a');
                    res.append(cur);
                }else{
                    res.append(ca);
                }
                ca = 0;
            }
        }
        while(res.length() > 1 && res.charAt(res.length()-1) == '0')
            res.deleteCharAt(res.length()-1);
        return res.reverse().toString();
    }
}
