package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 60 矩形相交的面积
 *
 * 给出3组点坐标(x, y, w, h)，-1000<x,y<1000，w,h为正整数。
 * (x, y, w, h)表示平面直⻆坐标系中的一个矩形:
 * x, y为矩形左上⻆坐标点，w, h向右w，向下h。
 * (x, y, w, h)表示x轴(x, x+w)和y轴(y, y-h)围城的矩形区域;
 * (0, 0, 2, 2)表示 x轴(0, 2)和y 轴(0, -2)围城的矩形区域;
 * (3, 5, 4, 6)表示x轴(3, 7)和y轴(5, -1)围城的矩形区域;
 * 求3组坐标构成的矩形区域重合部分的面积。
 */
public class Interview60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sa = scanner.nextLine().trim();
        String sb = scanner.nextLine().trim();
        String sc = scanner.nextLine().trim();
        String[] splita = sa.split("\\s+");
        String[] splitb = sb.split("\\s+");
        String[] splitc = sc.split("\\s+");
        int[] numsa = new int[4];
        int[] numsb = new int[4];
        int[] numsc = new int[4];
        for (int i = 0; i < 4; i++) {
            numsa[i] = Integer.parseInt(splita[i]);
            numsb[i] = Integer.parseInt(splitb[i]);
            numsc[i] = Integer.parseInt(splitc[i]);
        }
        int left = Math.max(numsa[0],Math.max(numsb[0],numsc[0]));
        int right = Math.min(numsa[0]+numsa[2],Math.min(numsb[0]+numsb[2],numsc[0]+numsc[2]));
        if(right <= left){
            System.out.println(-1);
            return;
        }
        int top = Math.min(numsa[1],Math.min(numsb[1],numsc[1]));
        int bottom = Math.max(numsa[1]-numsa[3],Math.max(numsb[1]-numsb[3],numsc[1]-numsc[3]));
        if(top <= bottom){
            System.out.println(-1);
            return;
        }
        System.out.println((right-left) * (top - bottom));
    }
}
