package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 63 靠谱的⻋
 * 1. 23再多一块钱就变为25;
 * 2. 39再多一块钱变为50;
 * 3. 399再多一块钱变为500;
 *  只有一行，数字N，表示里程表的读数。
 * (1<=N<=888888888)。
 */
public class Interview63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            int ans = N, temp = 0, k = 0, j = 1;
            while (N > 0) {
                //先判断个位上是否跳了4，如果个位上是5~9，就先temp=1。
                if (N % 10 > 4) {
                    temp += (N % 10 - 1) * k + j;
                } else {
                    temp += (N % 10) * k;
                }
                k = k * 9 + j;//k代表跳了多少次4，多收了多少个1元
                j *= 10;//j代表位数，1代表个位，10代表十位
                N /= 10;//相当于将N整体右移一位
            }
            System.out.println(ans - temp);
        }
    }
}
