package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 考勤信息
 * 公司用一个字符串来表示员工的出勤信息
 * absent:缺勤
 * late:迟到
 * leaveearly:早退
 * present:正常上班
 *
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下:
 * 1.缺勤不超过一次;
 * 2.没有连续的迟到/早退;
 * 3.任意连续7次考勤，缺勤/迟到/早退不超过3次。
 *
 2
 present
 present absent present present leaveearly present absent
 =>
 true
 false

 1
 absent leaveearly leaveearly
 */
public class Interview107H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().trim().split("\\s+");
            System.out.println(check(split));
        }
    }
    private static boolean check(String[] days) {
        //1.缺勤不超过一次;2.没有连续的迟到/早退; 3.任意连续7次考勤，缺勤/迟到/早退不超过3次。
        int absent = 0,lateOrearly = 0,non_pre = 0;
        for (int i = 0; i < days.length; i++) {
            if("absent".equals(days[i])){
                absent++;
            }else if("present".equals(days[i])){
                lateOrearly = 0;
            }else{
                lateOrearly++;
            }
            if(absent > 1 || lateOrearly >= 2)return false;
        }
        for (int i = 0; i < days.length && i < 7; i++) {
            if(!"present".equals(days[i]))non_pre++;
        }
        if(non_pre > 3)return false;
        for (int l = 0,r = 6; r < days.length; r++,l++) {
            if(!"present".equals(days[r]))non_pre++;
            if(!"present".equals(days[l]))non_pre--;
            if(non_pre > 3)return false;
        }
        return true;
    }
}
