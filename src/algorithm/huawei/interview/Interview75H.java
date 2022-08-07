package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间交集
 * 给定一组闭区间，其中部分区间存在交集。
 * 任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间 为[3,5])。
 * 公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。
 * 按升序排列输出合并后的区间列表。
 [[0,3],[1,3],[3,5],[3,6]]
 =》1，5
 [0,3]和[1,3]的公共区间为[1,3]，[0,3]和[3,5]的公共区间为[3,3]，[0,3]和[3,6]的公共区间为[3,3]，
 [1,3]和[3,5]的公共区间为[3,3]，[1,3]和[3,6]的公共区间为[3,3]，
 [3,5]和[3,6]的公共区间为[3,5]，
 公共区间列表为[[1,3],[3,3],[3,5]]；[1,3],[3,3],[3,5]存在交集，须合并为[1,5]。

 */
public class Interview75H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("\\]", "");
        String[] split = str.split(",");
        int n = split.length >> 1;
        int[][] matrix = new int[n][2];
        for (int i = 0; i < split.length; i++) {
            int cur = 0;
            if (split[i].trim().charAt(0) == '-') {
                cur = -1 * Integer.parseInt(split[i].trim().substring(1, split[i].length()));
            } else {
                cur = Integer.parseInt(split[i].trim());
            }
            if (i % 2 == 0) matrix[i / 2][0] = cur;
            else matrix[i / 2][1] = cur;
        }
        Arrays.sort(matrix,(a,b)-> a[0]-b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        //取出交集列表
        for (int i = 0; i < n; i++) {
            for(int j = i+1;j < n;j++) {
                if (matrix[j][0] <= matrix[i][1]) {
                    int a = matrix[j][0];
                    int b = Math.min(matrix[i][1], matrix[j][1]);
                    list.add(new int[]{a, b});
                }
            }
        }
        list.sort((a,b)->a[0]-b[0]);
        ArrayList<int[]> list2 = new ArrayList<>();
        //合并
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] <= list.get(i-1)[1]){

                list.get(i)[0] = list.get(i-1)[0];
                list.get(i)[1] = Math.max(list.get(i)[1],list.get(i-1)[1]);
            }else{
                list2.add(new int[]{list.get(i-1)[0],list.get(i-1)[1]});
            }
        }
        list2.add(new int[]{list.get(list.size()-1)[0],list.get(list.size()-1)[1]});
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int[] arr:list2){
            res.append("[");
            res.append(arr[0]);
            res.append(",");
            res.append(arr[1]);
            res.append("]");
            res.append(",");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        System.out.println(res);
    }
}
