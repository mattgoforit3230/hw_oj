package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 给航天器一侧加装⻓方形或正方形的太阳能板(图中的红色斜线区域)，需要先安装两个支柱(图中的 黑色竖条)，再在支柱的中间部分固定太阳能板。
 * 但航天器不同位置的支柱⻓度不同，太阳能板的安装面积受限于最短一侧的那根支柱⻓度。如图:
 * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位⻓度，计算如何选择两根支 柱可以使太阳能板的面积最大。
 * 输入描述:
 * 10,9,8,7,6,5,4,3,2,1
 * 注:支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中 递减只是巧合。
 * 输出描述:
 * 可以支持的最大太阳能板面积:(10米高支柱和5米高支柱之间)
 */
//暴力法
public class Interview11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splits = s.split(",");
        int n = splits.length;
        int[] heights = new int[n];
        for(int i = 0;i < n;i++){
            heights[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(helper(heights));
    }
    public static int helper(int[] heights) {
        int res = 0;
        int n = heights.length;
        for(int i = 0; i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(heights[j] > heights[i]){
                    res = Math.max(res,heights[i]*(j-i));
                }else{
                    res = Math.max(res,heights[j]*(j-i));
                }
            }
        }
        return res;
    }
}
