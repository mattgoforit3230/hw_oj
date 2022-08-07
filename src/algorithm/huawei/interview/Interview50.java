package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 50 找终点
 *
 7 5 9 4 2 6 8 3 5 4 3 9
 =>2
 1 2 3 7 1 5 9 3 2 1
 */
public class Interview50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int len = split.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(len-1);
        int step = 1;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            while(size-->0) {
                int temp = queue.poll();
                for (int i = temp - 1; i >= 0; i--) {
                    if (ints[i] + i == temp) {
                        queue.add(i);
                        if(i < len >> 1){
                            System.out.println(step);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);



//        int res = -1;
//        int cur = 0;
//        for (int i = 1; i < len / 2; i++) {
//            cur = i;
//            int step = 1;
//            while(cur < len-1){
//                cur += ints[cur];
//                step++;
//            }
//            if(cur == len-1){
//                if(res == -1)res = step;
//                else res = Math.min(res,step);
//            }
//        }
//        System.out.println(res);
    }
}
