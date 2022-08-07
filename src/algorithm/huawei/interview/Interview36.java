package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 36 按索引范围翻转文章片段
 *  输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。
 *  例如输入字符 串"I am a developer. "，区间[0,3]，则输出"developer. a am I"。
 * String reverseWords(String s, int start, int end)
 */
public class Interview36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int start = Integer.parseInt(scanner.nextLine().trim());
        int end = Integer.parseInt(scanner.nextLine().trim());
        reverseWords(s,start,end);
    }
    public static void reverseWords(String s, int start, int end){
        String[] split = s.split("\\s+");
        if(end >= split.length){
            System.out.println("EMPTY");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < split.length;i++){
            if(i >= start && i <= end){
                sb.append(split[start + end - i]);
            }else{
                sb.append(split[i]);
            }
            sb.append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
