package algorithm.a_leecodeEveryday.b_contest.contest2021_9;

import java.util.HashMap;

public class Contest911_01 {
    //LCP 39. 无人机方阵
    public static void main(String[] args) {
        //[[1,3],[5,4]]
        //[[3,1],[5,4]]
        System.out.println(minimumSwitchingTimes(new int[][]{{1,3},{5,4}},new int[][]{{3,1},{5,4}}));
    }
    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        //用一个map存就好了。。。
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] temp:
             source) {
            for (int a :temp
                 ) {
                map.put(a,map.getOrDefault(a,0)+1);
            }
        }

        for (int[] temp:
                target) {
            for (int a :temp
            ) {
                if(map.containsKey(a)){
                    int sum = map.get(a)-1;
                    if(sum == 0){
                        map.remove(a);
                    }else{
                        map.put(a,sum);
                    }
                }else {
                    res++;
                }
            }
        }


        return res;
    }
}
