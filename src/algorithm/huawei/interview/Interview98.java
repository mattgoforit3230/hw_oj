package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 勾股数元组
 *  如果3个正整数(a,b,c)满足a2 + b2 = c2的关系，则称(a,b,c)为勾股数(著名的勾三股四弦五)，
 * 为了探索勾股数的规律，我们定义如果勾股数(a,b,c)之间两两互质(即a与b，a与c，b与c之间均 互质，没有公约数)，
 * 则其为勾股数元祖(例如(3,4,5)是勾股数元祖，(6,8,10)则不是勾股数元 祖)。
 * 请求出给定范围[N,M]内，所有的勾股数元组。
 */
public class Interview98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine().trim());
        int end = Integer.parseInt(scanner.nextLine().trim());
        boolean flag = false;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (check(i, j)) {
                    int temp = i * i + j * j;
                    int k = (int) Math.sqrt(temp);
                    if (k > end) break;
                    if (k * k != temp) {
                        continue;
                    }
                    if (check(i, k) && check(j, k)) {
                        flag = true;
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        if (!flag){
            System.out.println("NA");
        }
    }
    // 是否互质，是true
    public static boolean check(int a, int b) {
        int temp = 0;
        while(b > 0){
            temp = a;
            a = b;
            b = temp % b;
        }
        return a == 1;
    }
}
