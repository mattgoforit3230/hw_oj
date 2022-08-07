package algorithm.a_leecodeEveryday._again.qianzhuihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Contest911_02 {
    //LCP 40. 心算挑战
    /**
     * 2. 心算挑战
     * 题目难度Easy
     * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
     * 输入：cards = [1,2,8,9], cnt = 3
     * 输出：18
     */
    public static void main(String[] args) {
        //[1,2,8,9]
        System.out.println(maxmiumScore(new int[]{1,3,8,9},4));
    }
    public static int maxmiumScore(int[] cards, int cnt) {
        int res = 0;
        Arrays.sort(cards);
        //int[] odd = new int[cards.length+1];
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        //int[] even = new int[cards.length+1];
        odd.add(0,0);
        even.add(0,0);
        int a = 1,b = 1;
        for (int i = cards.length-1; i >= 0; i--) {
            if(cards[i] % 2 != 0){
                odd.add(a,odd.get(a-1)+cards[i]);
                //odd[a++] = odd[a-1]+cards[i];
                a++;
            }else{
                even.add(b,even.get(b-1)+cards[i]);
                //even[b++] =even[b-1]+ cards[i];
                b++;
            }
        }
        //k为偶数
        for (int i = 0; i <= Math.min(odd.size()-1,cnt); i+=2) {
            if(cnt-i >= even.size())continue;
            res = Math.max(res,odd.get(i)+even.get(cnt-i));
            //res = Math.max(res,odd[i]+even[cnt-i]);
        }

        return res;
    }
}
