package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 火星文计算
 * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下: x#y = 2*x+3*y+4
 * x$y = 3*x+y+2
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算 3、火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算
 * 现有一段火星人的字符串报文，请你来翻译并计算结果。
 *
 *  火星人字符串表达式(结尾不带回⻋换行)
 *  输入的字符串说明:字符串为仅由无符号整数和操作符(#、$)组成的计算表达式。
 *  例如:123#4$5#67$78。
 7#6$5#12
 =》226
 8#23$23#23#83$1#2$#4
=>8528
 */
public class Interview100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Character> stark2 = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur >= '0' && cur <= '9') {
                num = num * 10 + cur - '0';
                if(i == str.length()-1)stack1.push(num);
            } else {
                if(!stark2.isEmpty() && stark2.peek() == '$'){
                    stark2.pop();
                    num = 3 * stack1.pop() + num + 2;
                    stack1.push(num);
                    num = 0;
                }else{
                    stack1.push(num);
                    num = 0;
                }
                stark2.push(cur);
            }
        }
        int res = stack1.removeLast();
        while(!stack1.isEmpty()){
            res = res * 2 + stack1.removeLast()*3+4;
        }
        System.out.println(res);
    }
}
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String input = sc.nextLine().trim();
//            System.out.println(func(input));
//        }
//        sc.close();
//    }
//    private static int func(String input) {
//        int index = input.lastIndexOf("#");
//        if (index != -1) {
//            String left = input.substring(0, index);
//            String right = input.substring(index + 1);
//            return 2 * func(left) + 3 * func(right) + 4;
//        }
//        index = input.lastIndexOf("$");
//        if (index != -1) {
//            String left = input.substring(0, index);
//            String right = input.substring(index + 1);
//            return 3 * func(left) + func(right) + 2;
//        }
//        return Integer.parseInt(input);
//    }
//}
