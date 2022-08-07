package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 78 水仙花数/字符串分割
 * 给定非空字符串s，将该字符串分割成一些子串，使每个子串的ASCII码值的和均为水仙花数。
 * 1、若分割不成功，则返回0;
 * 2、若分割成功且分割结果不唯一，则返回-1;
 * 3、若分割成功且分割结果唯一，则返回分割后子串的数目。
 *
 AXdddF
 =>2
 f3@d5a8
 =>-1
 abc
 =>0
 */
public class Interview78 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            // 超过长度200，返回分割不成功
            if (line.length() > 200) {
                System.out.println(0);
            }
            ArrayList<String> strings = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            calculate(line, 0, 0, stringBuilder, strings);

            // 分割结果不唯一打印-1
            if (strings.size() > 1) {
                System.out.println(-1);
            }
            // 分割结果唯一打印2
            if (strings.size() == 1) {
                System.out.println(2);
            }
            // 分割没有结果打印0
            if (strings.size() == 0) {
                System.out.println(0);
            }
    }
    public static boolean calculate(String str, int temp,
                                    int index, StringBuilder s, ArrayList<String> strings) {
        // 水仙花数为三位数
        if (temp > 999) {
            s.setLength(0);
            return false;
        }

        // 判断前一截字串是否为水仙花数
        if (isvalid(temp)) {
            if (index >= str.length()) {
                strings.add(s.toString());
                return true;
            }
            char c = str.charAt(index++);

            s.append(" ");
            s.append(c);
            calculate(str, c, index, s, strings);

            String[] s1 = s.toString().split(" ");
            s.setLength(0);
            for (int i = 0; i < s1.length; i++) {
                if (i == s1.length - 1) {
                    break;
                }
                s.append(s1[i]);
                if (i < s1.length - 2) {
                    s.append(" ");
                }
            }
            temp += c;
            s.append(c);
            return calculate(str, temp, index, s, strings);
        } else {
            if (index >= str.length()) {
                return false;
            }
            char c = str.charAt(index++);
            temp += c;
            s.append(c);
            return calculate(str, temp, index, s, strings);
        }
    }
    public static boolean isvalid(int n){
        if (n < 100 || n > 999) return false;
        int sum = 0,i = n;
        while(i > 0){
            int cur = i % 10;
            sum += Math.pow(cur,3);
            i /= 10;
        }
        return sum == n;
    }
}
