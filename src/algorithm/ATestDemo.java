package algorithm;


import java.io.IOException;
import java.util.*;
//git测试
public class ATestDemo {
    public static void main(String[] args) {
        System.out.println(solveEquation("-x=-1"));

    }
    public static String solveEquation(String equation) {
        String[] split = equation.split("=");
        int x = 0, xn = Integer.MAX_VALUE;
        int n = 0, num = 0;
        char sign = '+';
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < split[0].length(); i++) {
            char cur = split[0].charAt(i);
            if(cur == 'x'){
                x += xn == Integer.MAX_VALUE?(sign=='+'?1:-1):(sign=='+'?xn:-xn);
                xn = Integer.MAX_VALUE;
                n = 0;
            }else if(cur >= '0' && cur <= '9') {
                n = n * 10 - '0' + cur;
                xn = (xn == Integer.MAX_VALUE?0:xn) * 10 - '0' + cur;
                if(i == split[0].length() - 1 || split[0].charAt(i+1) < '0'){
                    stack.push(sign=='+'?n:-n);
                    n = 0;
                    xn = Integer.MAX_VALUE;
                }
            } else {
                sign = cur;
            }
        }
        xn = Integer.MAX_VALUE;
        sign = '+';
        for (int i = 0; i < split[1].length(); i++) {
            char cur = split[1].charAt(i);
            if(cur == 'x'){
                x -= xn == Integer.MAX_VALUE?(sign=='+'?1:-1):(sign=='+'?xn:-xn);
                xn = Integer.MAX_VALUE;
                n = 0;
            }else if(cur >= '0' && cur <= '9') {
                n = n * 10 - '0' + cur;
                xn = (xn == Integer.MAX_VALUE?0:xn) * 10 - '0' + cur;
                if(i == split[1].length() - 1 || split[1].charAt(i+1) < '0'){
                    stack.push(sign=='+'?-n:n);
                    n = 0;
                    xn = Integer.MAX_VALUE;
                }
            } else {
                sign = cur;
            }
        }
        while(!stack.isEmpty())num += stack.pop();
        if(x == 0){
            return num==0?"Infinite solutions":"No solution";
        }
        return "x="+-num/x;
    }
}