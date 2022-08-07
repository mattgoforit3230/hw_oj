package algorithm.huawei.interview;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IPv4地址转换成整数
 * 存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~128，以#号间隔，格式如下: (1~128)#(0~255)#(0~255)#(0~255)
 * 请利用这个特性把虚拟IPv4地址转换为一个32位的整数，IPv4地址以字符串形式给出，要求每个 IPvV4地址只能对应到唯一的整数上。
 * 如果是非法IPv4，返回invalid IP。
 * 输入描述
 * 输入一行，虚拟IPv4地址格式字符串
 * 输出描述
 *   输出一行，按照要求输出整型或者特定字符
 *
 *   https://www.jianshu.com/p/70185244e46c
 *   100#101#1#5 -> 1684340997
 */
public class Interview16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipv4 = sc.next();
        ipv4ToInt(ipv4);
    }
    public static boolean isValidIpv4(String ipv4) {
        String first = "(\\d|[1-9]\\d|1[0-1]\\d|12[0-8])";
        String tail = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = first + "(\\#" + tail +"){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4);
        return matcher.matches();
    }
    public static void ipv4ToInt(String ipv4) {
        if (!isValidIpv4(ipv4)) {
            System.out.println("invalid IP");
            return; }
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(ipv4);
//        int result = 0;
//        int counter = 0;
//        while (matcher.find()) {
//            int value = Integer.parseInt(matcher.group());
//            result = (value << 8 * (3 - counter++)) | result;
//        }
//        System.out.println(result);
        String[] split = ipv4.split("#");
        int res = 0;
        for(int i = 0;i < split.length;i++){
            int val = Integer.parseInt(split[i]);
            res |= val << (8 * (3 - i));
        }
        System.out.println(res);
    }

    public static void intToIpv4(int num){

    }
}
