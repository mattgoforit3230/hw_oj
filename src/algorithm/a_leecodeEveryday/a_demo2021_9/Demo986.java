package algorithm.a_leecodeEveryday.a_demo2021_9;
import java.util.*;
public class Demo986 {
    public static void main(String[] args) {
        intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24},{25,26}});

    }
    //986. 区间列表的交集
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //[[0,2],[5,10],[13,23],[24,25]]
        //[[1,5],[8,12],[15,24],[25,26]]
        ArrayList<int[]> res = new ArrayList<>();
        int first = 0,second = 0;
        while(first < firstList.length && second < secondList.length){
            if(firstList[first][0]>secondList[second][1]){
                if(second < secondList.length){
                    second++;
                }
            }else if(secondList[second][0] > firstList[first][1]){
                if(first <  firstList.length){
                    first++;
                }
            }else{
                int a = Math.max(firstList[first][0],secondList[second][0]);
                int b = Math.min(firstList[first][1],secondList[second][1]);
                res.add(new int[]{a,b});
                if(firstList[first][1]>secondList[second][1]){
                    second++;
                }else{
                    first++;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
