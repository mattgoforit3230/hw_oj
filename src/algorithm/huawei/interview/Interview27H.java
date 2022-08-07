package algorithm.huawei.interview;

import java.util.Scanner;
import java.util.TreeSet;

public class Interview27H {
    static TreeSet<Integer> set;
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        N = Integer.parseInt(str);
        set = new TreeSet<Integer>();
        String str2 = scanner.nextLine().trim();
        str2 = str2.substring(1,str2.length()-1);
        String[] split = str2.split(",");
        int res = -1;
        for(int i = 0;i < split.length;i++){
            int cur = Integer.parseInt(split[i]);
            if(cur == 1) {
                if(set.size() == N){
                    System.out.println(-1);
                    return;
                }else{
                    res = seat();
                }
            }
            else{
                remove(Math.abs(cur));
            }
        }
        System.out.println(res);
    }
    private static void remove(int i) {
        set.remove(i);
    }
    public static int seat(){
        int res = 0;
        int pre = -1;
        if(set.size() > 0){
            int dist = set.first();
            for(int cur:set){
                if(pre != -1){
                    int temp = cur - pre >> 1;
                    if(temp > dist){
                        dist = temp;
                        res = pre + temp;
                    }
                }
                pre = cur;
            }
            if(N-1-set.last() > dist)res = N-1;
        }
        set.add(res);
        return res;
    }
}
