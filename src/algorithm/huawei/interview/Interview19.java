package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 全量和已占用字符集
 * 给定两个字符集合，一个是全量字符集，一个是已占用字符集，已占用字符集中的字符不能再使用
 * 要求输出剩余可用字符集。
 * 输入描述
 * 1. 输入一个字符串 一定包含@@前为全量字符集 @后的为已占用字符集
 * 2. 已占用字符集中的字符一定是全量字符集中的字符
 * 3. 字符集中的字符跟字符之间使用英文逗号隔开
 * 4. 每个字符都表示为字符+数字的形式用英文冒号分隔，比如a:1标识一个a字符 5. 字符只考虑英文字母，区分大小写
 * 6. 数字只考虑正整型 不超过100
 * 7. 如果一个字符都没被占用 @标识仍存在 8. 例如 a:3,b:5,c:2@
 */
public class Interview19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("@");
        String[] add = split[0].split(",");
        String[] sub = split[1].split(",");
        //52+32
        int[] nums = new int[84];
        int[] order = new int[add.length];
        for(int i = 0;i < add.length;i++){
            char cur = add[i].charAt(0);
            order[i] = cur-'A';
            nums[cur-'A'] = Integer.parseInt(add[i].substring(2));
        }
        for(int i = 0;i < sub.length;i++){
            char cur = sub[i].charAt(0);
            nums[cur-'A'] -= Integer.parseInt(sub[i].substring(2));
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < add.length;i++){
            if(nums[order[i]]!=0){
                char cur = (char)(order[i]+'A');
                res.append(cur);
                res.append(":");
                res.append(nums[order[i]]);
                res.append(",");
            }
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
