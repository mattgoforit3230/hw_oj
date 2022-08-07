package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 44 查找众数及中位数
 * 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 * 2. 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中
 * 间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果
 * 就是中位数。
 * 3. 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。

 10 11 21 19 21 17 21 16 21 18 15 =》 21
 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4 =》 3
 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39 =》 7
 */
public class Interview44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int n = split.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(split[i]);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, map.get(cur));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue() == max)list.add(entry.getKey());
        }
        list.sort((a,b)->a-b);
        if(list.size() % 2 == 1){
            System.out.println(list.get(list.size() >> 1));
        }else{
            int sum = list.get(list.size() >> 1) + list.get((list.size()-1) >> 1);
            System.out.println(sum >> 1);
        }
    }
}
