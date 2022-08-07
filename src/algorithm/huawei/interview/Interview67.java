package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 绘图机器
 * 1. 尝试沿着横线坐标正向绘制直线直到给定的终点E
 * 2. 期间可以通过指令在纵坐标轴方向进行偏移，offsetY为正数表示正向偏移,为负数表示负向偏移
 *给定的横坐标终点值E 以及若干条绘制指令 请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
 *
 * 首行为两个整数 N 和 E 表示有N条指令,
 * 机器运行的横坐标终点值E 接下来N行 每行两个整数表示一条绘制指令x offsetY
 * 用例保证横坐标x以递增排序的方式出现 且不会出现相同横坐标x
 * 取值范围
 * 0<N<=10000
 * 0<=x<=E<=20000
 * -10000<=offsetY<=10000
 *
 4 10
 1 1
 2 1
 3 1
 4 -2
 =>12
 2 4
 0 1
 2 -2
 =>4
 */
public class Interview67 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int N = Integer.parseInt(str.split("\\s+")[0]);
        int E = Integer.parseInt(str.split("\\s+")[1]);
        int[][] change = new int[N][2];
        for (int i = 0; i < N; i++) {
            change[i][0] = scanner.nextInt();
            change[i][1] = scanner.nextInt();
        }
        int curx = 0,cury = 0,sum = 0;
        for (int[] diff : change){
            sum += Math.abs(cury) * (diff[0] - curx);
            curx = diff[0];
            cury += diff[1];
        }
        sum += Math.abs(cury) * (E - curx);
        System.out.println(sum);
    }
}
