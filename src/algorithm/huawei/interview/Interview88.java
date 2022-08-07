package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数组拼接
 * 现在有多组整数数组，需要将它们合并成一个新的数组。
 * 合并规则，从每个数组里按顺序取出固定⻓度的内容合并到新的数组中，取完的内容会删除掉，如果该
 * 行不足固定⻓度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 *
 *  第一行是每次读取的固定⻓度，0<⻓度<10 第二行是整数数组的数目，0<数目<1000
 * 第3-n行是需要合并的数组，不同的数组用回⻋换行分隔，数组内部用逗号分隔，最大不超过100 个元素。
 *
 * 输出一个新的数组，用逗号分隔。
 *
 3
 2
 2,5,6,7,9,5,7
 1,7,4,3,4
 =>2,5,6,1,7,4,7,9,5,3,4,7

 4
 3
 1,2,3,4,5,6
 1,2,3
 1,2,3,4
 =>1,2,3,4,1,2,3,1,2,3,4,5,6

 */
public class Interview88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine().trim());
        int n = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<String[]> list = new ArrayList<>();
        int size  =0;
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().trim().split(",");
            size = Math.max(split.length,size);
            list.add(split);
        }
        ArrayList<String> res = new ArrayList<>();
        int cur = 0;
        while(cur < size) {
            for (String[] temp : list) {
                if (cur >= temp.length) continue;
                for (int i = cur; i < cur+k && i < temp.length; i++) {
                    res.add(temp[i]);
                }
            }
            cur += k;
        }
        System.out.println(String.join(",",res));

    }
}
