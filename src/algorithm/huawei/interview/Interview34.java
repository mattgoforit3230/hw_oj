package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 34 字符串分割
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，
 * 给定正整数K，要求除第一个子串外，其 余的子串每K个字符组成新的子串，并用‘-’分隔。
 * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母 转换为小写字母;
 * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转 换为大写字母;
 *   大小写字母的数量相等时，不做转换。
 */
public class Interview34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine().trim());
        String s = scanner.nextLine();
        int index = s.indexOf("-");
        ArrayList<String> list = new ArrayList<>();
        if(index!=-1)list.add(s.substring(0,index));
        int cap = 0,lower = 0,len = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = index + 1;i < s.length();i++){
            char cur = s.charAt(i);
            if(cur >= 'A' && cur <= 'Z'){
                len++;
                cap++;
                sb.append(cur);
            }else if(cur >= 'a' && cur <= 'z'){
                len++;
                lower++;
                sb.append(cur);
            }else if(cur != '-'){
                sb.append(cur);
                len++;
            }
            if(len == k || i == s.length()-1){
                if(cap > lower){
                    list.add(sb.toString().toUpperCase());
                }else if(cap < lower){
                    list.add(sb.toString().toLowerCase());
                }else{
                    list.add(sb.toString());
                }
                cap = 0;
                lower = 0;
                len = 0;
                sb.delete(0,sb.length());
            }
        }
        System.out.println(String.join("-",list));
    }
}
