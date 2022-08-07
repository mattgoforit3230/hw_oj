package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 【编程题目 |100分】消消乐游戏【2022 Q1,Q2 考试题】
 * 输入原始字符串 str ，只能包含大小写英文字母，字母的大小写敏感， str ⻓度不超过100。
 */
public class Interview58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty() || stack.peek() != chars[i]){
                stack.push(chars[i]);
            }else{
                stack.pop();
            }
        }
        System.out.println(stack.size());
    }
}
