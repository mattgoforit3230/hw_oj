package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  最⻓的顺子
 *  牌型:单顺，又称顺子，最少5张牌，最多12张牌(3...A)不能有2，也不能有大小王，不计花色。
 *  例如 3-4-5-6-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A
 *  可用的牌 3<4<5<6<7<8<9<10<J<Q<K<A<2<B(小王)<C(大王)，每种牌除大小王外有四种花色 (共有13*4+2张牌)
 *输入：
 *      1. 手上有的牌
 *      2. 已经出过的牌(包括对手出的和自己出的牌)
 * 输出：
 *      【对手】可能构成的最⻓的顺子(如果有相同⻓度的顺子，输出牌面最大的那个那一个)，
 *      如果无法构成顺子，则输出 NO-CHAIN
 *
 3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
 4-5-6-7-8-8-8
 =》9-10-J-Q-K-A
 */
public class Interview74H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().trim().split("-");
        String[] b = scanner.nextLine().trim().split("-");
        String[] strings = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A"};
        //int[] ints = new int[]{3,4,5,6,7,8,9,10,11,12,13,14};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(strings[i],i);
        }
        int[] remain = new int[12];
        Arrays.fill(remain,4);
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                remain[map.get(a[i])]--;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if(map.containsKey(b[i])){
                remain[map.get(b[i])]--;
            }
        }
        int max = 0;
        int[] res = new int[2];
        int r = 11,l = 11;
        for (; l >= 0; l--) {
            if(remain[l] <= 0){
                r = l-1;
            }
            if(r - l + 1 > max){
                max = r - l + 1;
                res[0] = l;
                res[1] = r;
            }
        }
        if(max < 5) System.out.println("NO-CHAIN");
        else{
            ArrayList<String> list = new ArrayList<>();
            for (int i = res[0]; i <= res[1] ; i++) {
                list.add(strings[i]);
            }
            System.out.println(String.join("-",list));
        }
    }
}
