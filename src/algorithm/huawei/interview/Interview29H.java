package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * [29 最大矩阵和]100分，但是题目有难度
 * 给定一个二维整数矩阵，要在这个矩阵中选出一个子矩阵，使得这个子矩阵内所有的数字和尽量
 *   大，我们把这个子矩阵称为和最大子矩阵，子矩阵的选取原则是原矩阵中一块相互连续的矩形区
 *   域。
 * 输入描述:
 * 输入的第一行包含2个整数n, m(1 <= n, m <= 10)，表示一个n行m列的矩阵，下面有n行，每行有 m个整数，
 * 同一行中，每2个数字之间有1个空格，最后一个数字后面没有空格，所有的数字的在 [-1000, 1000]之间。
 * 输出描述:
 *   输出一行一个数字，表示选出的和最大子矩阵内所有的数字和。
 *    3 4
 * -3 5 -1 5
 * 2 4 -2 4
 * -1 3 -1 3
 * => 20
 *
 3 5
 9 -8 1 3 -2 -3 7 6 -2 4 6 -4 -4 8 -7
 => 19
 */
public class Interview29H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] matrix = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int max = -1001;
        for(int i = 0;i < n;i++){
            int[] sum = new int[m];
            for(int j = i;j < n;j++){
                for(int k = 0;k < m;k++) {
                    sum[k] += matrix[j][k];
                }
                int temp = -1001;
                for(int k = 0;k < m;k++){
                    temp = Math.max(sum[k],sum[k]+temp);
                    max = Math.max(temp,max);
                }
            }
        }
        System.out.println(max);
    }
}
