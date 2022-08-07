package algorithm.huawei.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 任务最优调度
 * 数组的每一个元素代表一个任务，元素的值表示该任务的类型。请计算执行完所有任务所需的最短时间。
 *
 2,2,2,3
 =>
 */
public class Interview71H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int n = scanner.nextInt();
        String[] tasks = str.split(",");
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0,len = 0;
        for(String ch : tasks){
            map.merge(ch,1,Integer::sum);
            if(map.get(ch) > max){
                max = map.get(ch);
                len = 1;
            }else if(map.get(ch) == max){
                len++;
            }
        }
        int res = (max-1)*(n+1) + len;
        System.out.println(Math.max(res,tasks.length));
    }
}
