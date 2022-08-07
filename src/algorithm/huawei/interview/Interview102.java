package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 快递运输
 *  一辆运送快递的货⻋，运送的快递均放在大小不等的⻓方体快递盒中，
 *  为了能够装载更多的快递， 同时不能让货⻋超载，需要计算最多能装多少个快递。
 *  注:快递的体积不受限制，快递数最多1000个，货⻋载重最大50000。
 *
 *   第一行输入每个快递的重量，用英文逗号分隔，如:5,10,2,11 第二行输入货⻋的载重量，如:20
 * 不需要考虑异常输入。
 * 输出最多能装多少个快递，如:3
 *
 5,10,2,11
 20
 =>3
 */
public class Interview102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().trim()
                .split(",")).mapToInt(Integer::parseInt).toArray();
        int vol = scanner.nextInt();
        Arrays.sort(ints);
        int res = 0;
        int i = 0;
        while(vol > 0 && i < ints.length){
            vol -= ints[i++];
            if(vol > 0)res++;
        }
        System.out.println(res);

    }
}
