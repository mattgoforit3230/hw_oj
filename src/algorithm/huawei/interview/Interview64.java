package algorithm.huawei.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串中找出连续最⻓的数字串
 *请一个在字符串中找出连续最⻓的数字串，并返回这个字符串;
 * 如果存在⻓度相同的连续数字串,返回最后一个连续数字串;
 * 注意:数字串是由数字和“.”组成的(⻓度包括“.”在内)，“.”两边必须是数字，比如:
 * 数字串“1234”的⻓度就小于数字串“00055”，数字串“1234.56789”的⻓度大于数字串 “123456789”
 *
 abcd123.4567.890.123
 abcd12345ed125ss123058789
 abcd12345ss54761
 =>
 4567.890
 123058789
 54761
 */
public class Interview64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String regex = "[0-9]+(\\.[0-9]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        int res = 0;
        String s = "";
        while (matcher.find(i)){
            String group = matcher.group();
            if(group.length() >= res){
                res = group.length();
                s = group;
            }
            i++;
        }
        System.out.println(s);
    }
}
