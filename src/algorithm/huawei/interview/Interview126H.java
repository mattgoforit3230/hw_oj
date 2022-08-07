package algorithm.huawei.interview;

import java.util.*;

/**
 * 面试
 * 某公司组织一场公开招聘活动，假设由于人数和场地的限制，每人每次面试的时⻓不等，
 * 并已经安排给 定，用(S1,E1)、 (S2,E2)、 (Sj,Ej)...(Si < Ei，均为非负整数)表示每场面试的开始和结束时间。
 * 面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，
 * [且每个面试官的面试人次不超过 m]。 为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。
 2
 5
 1 2
 2 3
 3 4
 4 5
 5 6
 =》3
 */
public class Interview126H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine().trim());
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = Integer.parseInt(scanner.next());
            intervals[i][1] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(intervals,(a,b)->a[0] -b[0]);
        int res = 1;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        list.add(intervals[0][1]);
        map.put(0,1);
        for (int i = 1; i < intervals.length; i++) {
            //有现成可以使用，若为false则需要新建
            boolean addSucces = false;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j) <= intervals[i][0] && map.get(j) < m){
                    addSucces = true;
                    list.set(j,intervals[i][1]);
                    map.put(j,map.get(j)+1);
                    break;
                }
            }
            if(!addSucces){
                map.put(list.size(),1);
                list.add(intervals[i][1]);
                res++;
            }
        }
        System.out.println(res);
    }
}
