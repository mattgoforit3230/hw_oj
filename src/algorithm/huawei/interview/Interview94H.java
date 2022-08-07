package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 分糖果II
 *  Solo和koko是两兄弟，妈妈给了他们一大袋糖，每块糖上都有自己的重量。 现在他们想要将这些糖分成两堆。
 * 分糖的任务当然落到了大哥Solo的身上，然而koko要求必须两个人获得的糖的总重量“相等”(根 据Koko的逻辑)，要不然就会哭的。
 *非常不幸的是，koko还非常小，并且他只会先将两个数转成二进制再进行加法，而且总会忘记进位。 如当12(1100)加5(101)时:
 * 1100
 * + 0101 ———— 1001
 * 于是koko得到的计算结果是9(1001)。
 *  5 +4 =1
 * 7 + 9 = 14 50 + 10 = 56
 *
 5
 1 2 3 4 5
 =》no
 3
 3 5 6
 =>11
 */
public class Interview94H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            res ^= x;
            min = Math.min(min, x);
        }
        if (res != 0) {
            System.out.println("NO");
        } else {
            System.out.println(sum - min);
        }
    }
}
