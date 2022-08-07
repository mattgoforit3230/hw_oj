package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 在字符串中找出连续最⻓的数字串(含“+-”号)
 *  请在一个字符串中找出连续最⻓的数字串，并返回这个数字串。
 *  如果存在⻓度相同的连续数字串，返回最后一个。
 *  如果没有符合条件的字符串，返回空字符串""。
 *
 *   数字串可以由数字"0-9"、小数点"."、正负号"±"组成，
 *   ⻓度包括组成数字串的所有符号。
 *   "."、“±"仅能出现一次，”."的两边必须是数字，
 *   "±"仅能出现在开头且其后必须要有数字。
 *   ⻓度不定，可能含有空格。
 *
 1234567890abcd9.+12345.678.9ed
 => +12345.678
 */
public class Interview123H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(function(str));

    }
    public static String function(String s) {
        Pattern pattern = Pattern.compile("[+-]?[0-9]+(\\.[0-9]+)?");
        Matcher matcher = pattern.matcher(s);
        //List<String> list = new ArrayList<>();
        int i = 0;
//        while (matcher.find(i)) {
//            list.add(matcher.group());
//            i = matcher.start() + 1;
//        }
        String res= "";
        while(matcher.find(i)){
            String group = matcher.group();
            if(group.length() >= res.length())res = group;
            //i = matcher.start() + 1;
            i++;
        }
//        String result = "";
//        for (String target : list) {
//            if (target.length() >= result.length()) {
//                result = target;
//            }
//        }
//        return result;
        return res;
    }
}
