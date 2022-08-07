package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 *
 为了提升数据传输的效率，会对传输的报文进行压缩处理。 输入一个压缩后的报文，
 请返回它解压后的原始报文。 压缩规则:n[str]，表示方括号内部的 str 正好重复 n 次。
 注意 n 为正整数(0 < n <= 100)，str只包含小写英文字母，不考虑异常情况。
 输入描述:
 输入压缩后的报文:
 1)不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的; 2)原始报文不包含数字，
 所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入;
 输出描述:
 解压后的原始报文
 */
public class Interview8H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        ArrayDeque<StringBuilder> sbs = new ArrayDeque<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(cur - '0' >= 0 && cur - '0' <= 9){
                int temp = cur - '0';
                num = num * 10 + temp;
            }else if(cur == '['){
                integers.push(num);
                sbs.push(sb);
                sb = new StringBuilder();
                num = 0;
            }else if(cur == ']'){
                int temp = integers.pop();
                StringBuilder old = sbs.pop();
                for(int j = 0;j < temp;j++){
                    old.append(sb);
                }
                sb = old;
            }else{
                sb.append(cur);
            }
        }
        System.out.println(sb);
    }
}
