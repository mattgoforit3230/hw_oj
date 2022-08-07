package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 学生方阵
 * 请在矩形方阵中找到最大的位置相连的男生数量。
 * 这个相连位置在一个直线上，方向可以是水平的，垂直的，成对⻆线的或者呈反对⻆线的。
 * 注:学生个数不会超过10000
 *
 * 输入的第一行为矩阵的行数和列数，
 * 接下来的n行为矩阵元素，元素间用","分隔。
 *
 * 输出一个整数，表示矩阵中最⻓的位置相连的男生个数。
 *
 3,4
 F,M,M,F
 F,M,M,F
 F,F,F,M
 */
public class Interview46H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String temp = scanner.nextLine().trim();
            String[] split1 = temp.split(",");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = split1[j].charAt(0);
            }
        }
        int res = 0;
        // -
        int[][][] dp = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'F'){
                    if(j == 0)dp[i][j][0] = 1;
                    else dp[i][j][0] = dp[i][j-1][0]+1;
                }else{
                    dp[i][j][0] = 0;
                }
                res = Math.max(res,dp[i][j][0]);
            }
        }
        // |
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'F'){
                    if(i == 0)dp[i][j][1] = 1;
                    else dp[i][j][1] = dp[i-1][j][1]+1;
                }else{
                    dp[i][j][1] = 0;
                }
                res = Math.max(res,dp[i][j][1]);
            }
        }
        // \
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'F'){
                    if(i == 0||j == 0)dp[i][j][2] = 1;
                    else dp[i][j][2] = dp[i-1][j-1][2]+1;
                }else{
                    dp[i][j][2] = 0;
                }
                res = Math.max(res,dp[i][j][2]);
            }
        }
        // /
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                if(matrix[i][j] == 'F'){
                    if(i == 0||j == m-1)dp[i][j][3] = 1;
                    else dp[i][j][3] = dp[i-1][j+1][3]+1;
                }else{
                    dp[i][j][3] = 0;
                }
                res = Math.max(res,dp[i][j][3]);
            }
        }
        System.out.println(res);
    }
}
