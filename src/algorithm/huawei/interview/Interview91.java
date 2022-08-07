package algorithm.huawei.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 相对开音节
 *  相对开音节构成的结构为辅音+元音(aeiou)+辅音(r除外)+e，常⻅的单词有bike、cake等。
 * 给定一个字符串，以空格为分隔符，反转每个单词中的字母，若单词中包含如数字等其他非字母时
 * 不进行反转。
 * 反转后计算其中含有相对开音节结构的子串个数(连续的子串中部分字符可以重复)。
 *
 * 字符串，以空格分割的多个单词，字符串⻓度<10000，字母只考虑小写
 * 含有相对开音节结构的子串个数，注:个数<10000
 *
 ekam a ekac
 =》 2
 !ekam a ekekac
 =》2
 */
public class Interview91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        String[] words = line.split(" ");
        int count = 0;
        Pattern compile = Pattern.compile("[a-z]+");
        for (String word : words) {
            if (word.length() < 4) continue;
            Matcher matcher = compile.matcher(word);
            StringBuilder sb = new StringBuilder(word);
            if(matcher.matches())sb = sb.reverse();
            for (int i = 0; i < sb.length()-3; i++) {
                if(!isVowel(sb.charAt(i)) && isVowel(sb.charAt(i+1))
                        && !isVowel(sb.charAt(i+2)) &&
                        sb.charAt(i+2)!='r' &&
                        sb.charAt(i+3) == 'e'){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }
}
