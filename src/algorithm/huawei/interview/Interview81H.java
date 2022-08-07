package algorithm.huawei.interview;

import java.util.*;

/**
 * 斗地主之顺子
 * 在斗地主扑克牌游戏中， 扑克牌由小到大的顺序为:3,4,5,6,7,8,9,10,J,Q,K,A,2，
 * 玩家可以出的 扑克牌阵型有:单张、对子、顺子、⻜机、炸弹等。
 * 其中顺子的出牌规则为:由至少5张由小到大连续递增的扑克牌组成，且不能包含2。
 * 例如:{3,4,5,6,7}、{3,4,5,6,7,8,9,10,J,Q,K,A}都是有效的顺子;
 * 而{J,Q,K,A,2}、 {2,3,4,5,6}、 {3,4,5,6}、{3,4,5,6,8}等都不是顺子。
 * 给定一个包含13张牌的数组，如果有满足出牌规则的顺子，请输出顺子。
 * 如果存在多个顺子，请每行输出一个顺子，且需要按顺子的第一张牌的大小(必须从小到大)依 次输出。
 * 如果没有满足出牌规则的顺子，请输出No。
 *
 2 9 J2 3 4 K A 7 9 A 5 6
 =>3 4 5 6 7
 2 9 J 10 3 4 K A 7 Q A 5 6
 =>
 3 4 5 6 7
 9 10 J Q K A

 2 9 9 9 3 4 K A 10 Q A 5 6
 =>NO
 */
public class Interview81H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        String[] strings = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(strings[i],i);
        }
        int[] remain = new int[12];
        for (int i = 0; i < split.length; i++) {
            if(map.containsKey(split[i])){
                remain[map.get(split[i])]++;
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        while(true) {
            int[] dp = new int[12];
            dp[0] = remain[0] > 0 ? 1 : 0;
            int max = 0;
            for (int i = 1; i < 12; i++) {
                if (remain[i] > 0) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 0;
                }
                max = Math.max(max, dp[i]);
            }
            if(max < 5)break;
            for (int i = 0; i < 12; i++) {
                if (dp[i] == max) {
                    ArrayList<String> temp = new ArrayList<>();
                    for (int j = i-max+1; j <= i; j++) {
                        remain[j]--;
                        temp.add(strings[j]);
                    }
                    lists.add(temp);
                }
            }
        }
        if(lists.size() == 0){
            System.out.println("NO");
        }else{
            lists.sort((a,b)->map.get(a.get(0)) - map.get(b.get(0)));
            for(List<String> temp:lists){
                System.out.println(String.join(" ",temp));
            }
        }
    }
}
