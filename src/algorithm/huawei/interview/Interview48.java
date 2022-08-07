package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 执行时⻓ GDP算力
 * 现在有一个任务数组，数组元素 表示在这1秒内新增的任务个数且每秒都有新增任务。
 * 假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多⻓时 间执行完成。
 3
 5
 1 2 3 4 5
 =>6

 */
public class Interview48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cap = Integer.parseInt(scanner.nextLine().trim());
        int N = Integer.parseInt(scanner.nextLine().trim());
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = scanner.nextInt();
        }
        int under = 0,res = 0;
        int i = 0;
        while(under != 0 || i < N){
            if(i < N)under += ints[i++];
            if(under > cap){
                under -= cap;
            }else{
                under = 0;
            }
            res++;
        }
        System.out.println(res);
    }
}
