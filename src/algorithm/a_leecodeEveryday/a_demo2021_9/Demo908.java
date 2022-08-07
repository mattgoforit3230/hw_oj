package algorithm.a_leecodeEveryday.a_demo2021_9;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Demo908 {
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
    //502. IPO
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //贪心算法➕大根堆(根为最大值)java为PrirityQueue实现堆，同时定义大根（(a,b) -> b-a）;
        //第一次间的技术点,以capital为基准排序
        int[][] arr = new int[profits.length][capital.length];
        for (int i = 0; i < profits.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b - a);
        int curr = 0;
        for (int i = 0; i < k; i++) {
            //加
            while(curr<profits.length && w>=arr[curr][0]){
                priorityQueue.add(arr[curr][1]);
                curr++;
            }
            if(!priorityQueue.isEmpty()){
                w += priorityQueue.poll();
            }
        }
        return w;
    }
}
