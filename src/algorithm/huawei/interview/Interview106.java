package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 水仙花数
 *  所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。
 *  例如153是水仙花数，153是一个3位数，并且153 = 1^3 + 5^3 + 3^3。
 *
 *   第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。
 *   第二行输入一个正整数m，表示需要返回第m个水仙花数。
 */
public class Interview106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int k = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(fun(n, k));
    }
    public static int fun(int n, int k){
        if(n < 3 || n > 7)return -1;
        else if(n == 1) return k;
        else {
            int start = 1;
            for (int i = 0; i < n-1; i++) {
                start *= 10;
            }
            int end = start * 10 -1;
            int pre = -1, num = -1;
            for (int i = start; i <= end; i++) {
                if(isvalid(i)) {
                    pre = i;
                    num++;
                    if(num == k){
                        return  pre;
                    }
                }
            }
            return pre * k;
        }
    }
    public static boolean isvalid(int n){
        int sum = 0,i = n;
        while(i > 0){
            int cur = i % 10;
            sum += Math.pow(cur,3);
            i /= 10;
        }
        return sum == n;
    }
}
