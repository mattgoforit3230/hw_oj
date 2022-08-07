package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串统计
 *  给定两个字符集合，一个为全量字符集，一个为已占用字符集。
 * 已占用的字符集中的字符不能再使用，要求输出剩余可用字符集。
 *
 *输入描述
 * 1、输入为一个字符串，一定包含@符号。@前的为全量字符集，@后的字为已占用字符集。
 * 2、已占用字符集中的字符一定是全量字符集中的字符。字符集中的字符跟字符之间使用英文逗号分 隔。
 * 3、每个字符都表示为字符加数字的形式，用英文冒号分隔，比如a:1，表示1个a字符。
 * 、字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过100。
 * 5、如果一个字符都没被占用，@标识仍然存在，例如a:3,b:5,c:2@
 *
 a:3,b:5,c:2@a:1,b:2
 =》a:2,b:3,c:2

 a:3@a:3
 报错
 */
public class Interview120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = s.split("@");
        //a:2
        String[] all = split[0].split(",");
        if(split.length == 1) {
            System.out.println(split[0]+"@");
            return;
        }
        String[] occupied = split[1].split(",");
        ArrayList<Character> order = new ArrayList<>();
        int[] nums = new int[26];
        for(String temp : all){
            char cur = temp.charAt(0);
            int num = Integer.parseInt(temp.substring(2));
            order.add(cur);
            nums[cur-'a']+=num;
        }
        boolean flag = false;
        for(String temp : occupied){
            char cur = temp.charAt(0);
            int num = Integer.parseInt(temp.substring(2));
            if(num != 0)flag = true;
            nums[cur-'a'] -= num;
        }
        if(!flag){
            System.out.println(split[0]+"@");
            return;
        }
        StringBuilder res = new StringBuilder();
        for(char cur:order){
            if(nums[cur-'a']!=0){
                res.append(cur);
                res.append(":");
                res.append(nums[cur-'a']);
                res.append(",");
            }
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
