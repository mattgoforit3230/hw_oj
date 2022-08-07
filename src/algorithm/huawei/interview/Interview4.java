package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * [测试数据不足 ,待验证]
 * 1,0,0,1,0,
 * 0,0,1,0,1,
 * 1,0,0,1,1,
 * 0,0,0,1,1,
 * 1,0,0,1,0
 * 输入一行字符串，字符串可转换为N*N的二维数组，数组可认为是一个水域，
 * 判断多少天后，水域被全 部污染。 数组中只有0和1，0表示纯净，1表示污染，
 * 每天只可污染上下左右的水域，如果开始全部被污染，或 永远无法污染，则返回-1。
 */
public class Interview4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splits = s.split(",");
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int n = (int) Math.pow(splits.length,0.5);
        int k = 0;
        int[][] nums = new int[n][n];
        for(int i = 0;i < n;i++){
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(splits[k++]);
                nums[i][j] = temp;
                if(temp == 1)queue.add(new int[]{i,j});
            }
        }
        int res = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] temp = queue.poll();
                int x = temp[0];int y = temp[1];
                for(int[] dir:dirs){
                    int i = x + dir[0],j = y + dir[1];
                    if(i >= 0 && i < n && j >= 0 && j < n && nums[i][j] == 0){
                        queue.add(new int[]{i,j});
                        nums[i][j] = 1;
                    }
                }
            }
            res++;
        }
        System.out.println(res);
    }
}
