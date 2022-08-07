package algorithm.huawei.interview;

import java.util.Scanner;

/**
 *
 * 最大差
 * 判断一组不等式是否满足约束并输出最大差
 *给定一组不等式，判断是否成立并输出不等式的最大差(输出浮点数的整数部分) 要求:
 * 1)不等式系数为 double类型，是一个二维数组
 * 2)不等式的变量为 int类型，是一维数组;
 * 3)不等式的目标值为 double类型，是一维数组
 * 4)不等式约束为字符串数组，只能是:">",">=","<","="，
 *
 * 例如，不等式组:
 * a11x1+a12x2+a13x3+a14x4+a15x5<=b1;
 * a21x1+a22x2+a23x3+a24x4+a25x5<=b2;
 * a31x1+a32x2+a33x3+a34x4+a35x5<=b3;
 * 最大差 =max{(a11x1+a12x2+a13x3+a14x4+a15x5-b1),
 * (a21x1+a22x2+a23x3+a24x4+ a25x5-b2),
 * (a31x1+a32x2+a33x3+a34x4+a35x5-b3)},
 * 类型为整数(输出浮点数的整数部分)
 *
 2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 =》false,458
 */
public class Interview77H {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(";");
        in.close();
        int num_eq = str[str.length - 1].split(",").length;  // 3,等式的数量
        int num_x = str[0].split(",").length;  // 5，系数和未知数的数量
        double[][] a= new double[num_eq][num_x];
        int[] x = new int[num_x];
        double[] b = new double[num_eq];
        String[] eq = new String[num_eq];
        int[] res = new int[num_eq];
        int max = 0;
        boolean flag = true;
        // 分别处理a,x,b,符号
        for (int i = 0; i < num_eq; i++) {  // 处理a
            String[] tmp1 = str[i].split(",");
            for (int j = 0; j < tmp1.length; j++) {
                a[i][j] = Double.valueOf(tmp1[j]);
            }
        }
        String[] tmp2 = str[num_eq].split(",");
        for (int i = 0; i < tmp2.length; i++) {  // 处理x
            x[i] = Integer.parseInt(tmp2[i]);
        }
        String[] tmp3 = str[num_eq + 1].split(",");
        for (int i = 0; i < tmp3.length; i++) {  // 处理b
            b[i] = Double.valueOf(tmp3[i]);
        }
        String[] tmp4 = str[num_eq + 2].split(",");
        for (int i = 0; i < tmp4.length; i++) {  // 处理符号
            eq[i] = tmp4[i];
        }
        for (int i = 0; i < num_eq; i++) {
            double tmp = 0.0;
            for (int j = 0; j < num_x; j++) {
                tmp += a[i][j] * x[j];
            }
            if ("<=".equals(eq[i])) {
                flag = tmp <= b[i] ? flag && true : flag && false;
            } else if ("<".equals(eq[i])) {
                flag = tmp < b[i] ? flag && true : flag && false;
            }else if ("=".equals(eq[i])) {
                flag = tmp == b[i] ? flag && true : flag && false;
            }else if (">=".equals(eq[i])) {
                flag = tmp >= b[i] ? flag && true : flag && false;
            }else if (">".equals(eq[i])) {
                flag = tmp > b[i] ? flag && true : flag && false;
            }
            res[i] =(int) ((tmp - b[i]) / 1);
        }
        for (int i = 0; i < num_eq; i++) {
            max = Math.max(max, res[i]);
        }
        System.out.println(flag + " " + max);
    }
}
