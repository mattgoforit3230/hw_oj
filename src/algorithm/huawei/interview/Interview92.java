package algorithm.huawei.interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 喊7的次数重排
 *  喊7是一个传统的聚会游戏，N个人围成一圈，按顺时针从1到N编号。 编号为1的人从1开始喊数，
 *  下一个人喊的数字为上一个人的数字加1，但是当将要喊出来的数字是7
 * 的倍数或者数字本身含有7的话，不能把这个数字直接喊出来，而是要喊"过"。
 * 假定玩这个游戏的N个人都没有失误地在正确的时机喊了"过"，当喊到数字K时，可以统计每个人 喊"过"的次数。
 *  现给定一个⻓度为N的数组，存储了打乱顺序的每个人喊"过"的次数，请把它还原成正确的顺序，
 *  即数组的第i个元素存储编号i的人喊"过"的次数。
 0 1 0
 =》 1 0 0
 0 0 0 2 1
 =>0 2 0 1 0
 */
public class Interview92 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        int n = split.length;
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            sum += nums[i];
        }
        int i = 1;
        int[] res = new int[n];
        while(sum > 0){
            if(check(i)){
                sum--;
                res[(i-1)%n]++;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(res[j]);
            sb.append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
    private static boolean check(int i) {
        if(i % 7 == 0)return true;
        String s = String.valueOf(i);
        if(s.contains("7"))return true;
        return false;
    }
}
