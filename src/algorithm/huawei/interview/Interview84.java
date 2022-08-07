package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数字字符串组合倒序
 * 对数字，字符，数字串，字符串，以及数字与字符串组合进行倒序排列。
 * 字符范围:
 * 由 a 到 z， A 到 Z，数字范围:由 0 到 9
 *
 * 1. ”做为连接符使用时作为字符串的一部分，例如“20-years”作为一个整体字符串呈现;
 * 2. 连续出现 2 个’及以上时视为字符串间隔符，如“out–standing"中的"--"视为间隔符，是 2 个
 * 独立整体字符串"out"和"standing";
 * 3. 除了 1，2 里面定义的字符以外其他的所有字符，都是非法字符，作为字符串的间隔符处理，
 * 倒序后间隔符作为空格处理;
 * 4. 要求倒排后的单词间隔符以一个空格表示;如果有多个间隔符时，倒排转换后也只允许出现一
 * 个字格间隔符:
 I am an 20-years out--standing @ * -stu- dent
 => dent stu standing out 20-years an am I
 */
public class Interview84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        str = str.replaceAll("--"," ");
        //str = str.replaceAll("【^a-zA-Z0-9\\-]"," ");
        //System.out.println(str);
        String[] split = str.split("\\s+");
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if(isValid(s.charAt(j) )){
                    sb.append(s.charAt(j));
                }else if(s.charAt(j) == '-' && j!= 0 &&
                        j!=s.length()-1 && isValid(s.charAt(j-1))
                        && isValid(s.charAt(j+1))){
                    sb.append(s.charAt(j));
                }else{
                    if(sb.length() > 0) {
                        res.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
            }
            if(sb.length() > 0) {
                res.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = res.size()-1; i >= 0 ; i--) {
            out.append(res.get(i));
            out.append(" ");
        }
        System.out.println(out.substring(0,out.length()-1));
    }
    public static boolean isValid(char ch){
        if(ch >= '0' && ch <= '9' ||
                ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')return true;
        return false;
    }
}
