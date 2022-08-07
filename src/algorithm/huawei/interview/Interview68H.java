package algorithm.huawei.interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 仿 LISP 运算
 * LISP 语言唯一的语法就是括号要配对。
 * 形如 (OP P1 P2 ...)，括号内元素由单个空格分割。
 * 其中第一个元素 OP 为操作符，后续元素均为其参数，参数个数取决于操作符类型。
 举例:
 输入:(mul 3 -7)
 输出:21
 输入:(add 1 2)
 输出:3
 输入:(sub (mul 2 4) (div 9 3)) 输出:5
 输入:(div 1 0)
 输出:error
 (div 12 (sub 45 45)) =》error
 */
public class Interview68H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 存放操作符的栈
        Stack<String> opStack = new Stack<>();
        // 存放计算结果的栈
        Stack<Integer> dataStack = new Stack<>();
        try {
            exec(input, opStack, dataStack);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    /*
    1、从头开始遍历字符，遇到左括号，就将其后边的三个操作符压入操作符栈中
    2、遇到数字，就将其压入数据栈中（考虑连续数字和负数）
    3、遇到右括号，就从操作符栈中出栈最近的操作符
    4、然后在数据栈中出栈两个数字
    5、通过第3步的操作符和第4步的两个数字进行计算
    6、将第5步的计算结果压入数据栈中
    7、重复执行上述1~6，直到操作符栈为空，输出数据栈的结果即可
     */
    public static void exec(String input,
                            Stack<String> opStack, Stack<Integer> dataStack) {
        int length = input.length();
        for (int i = 0; i < length; ) {
            char c = input.charAt(i);
            // 如果是空格，跳过当前循环
            if (c == ' ') {
                i++;
                continue;
            }
            if (c == '(') {
                // 操作符入栈
                opStack.push(input.substring(i + 1, i + 4));
                // 修改循环下标并跳过当前循环
                i = i + 4;
                continue;
            }
            // 如果是数字，连续读取，并压入数据栈
            if (c == '-' || Character.isDigit(c)) {
                int j = i;
                while (Character.isDigit(input.charAt(j + 1))) {
                    j++;
                }
                dataStack.push(Integer.valueOf(input.substring(i, j + 1)));
                i = j + 1;
                continue;
            }
            if (c == ')') {
                // 取出操作符和数据，并将计算结果压入数据栈中
                String op = opStack.pop();
                Integer p2 = dataStack.pop();
                Integer p1 = dataStack.pop();
                Integer result = calculate(op, p1, p2);
                dataStack.push(result);
                i++;
            }
        }
        if (opStack.empty()) {
            // 如果操作符栈为空，则输出数据栈结果
            System.out.println(dataStack.pop());
        } else {
            throw new RuntimeException();
        }
    }

    public static Integer calculate(String op, Integer p1, Integer p2) {
        switch (op) {
            case "add":
                return p1 + p2;
            case "sub":
                return p1 - p2;
            case "mul":
                return p1 * p2;
            case "div":
                return p1 / p2;
            default:
                throw new RuntimeException();
        }
    }
}
