package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 运维日志排序
 *
 * 现需根据日志时间先后顺序对日志进行排序
 * 日志时间格式为H:M:S.N
 * H表示小时(0~23)
 * M表示分钟(0~59) S表示秒(0~59) N表示毫秒(0~999)
 *
 2
 01:41:8.9
 1:1:09.211

 3
 23:41:08.023
 1:1:09.211
 08:01:22.0

 2
 22:41:08.023
 22:41:08.23
 */
public class Interview61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine().trim();
            list.add(str);
        }
        list.sort((a,b)->getTime(a)-getTime(b));
        list.stream().forEach(System.out::println);
    }
    public static int getTime(String str){
        String[] split = str.split("[^0-9]");
        int res = 0;
        res = Integer.parseInt(split[0])*60;
        res = (res + Integer.parseInt(split[1]))*60;
        res = (res + Integer.parseInt(split[2]))*60;
        res += Integer.parseInt(split[3]);
        return res;
    }
}
