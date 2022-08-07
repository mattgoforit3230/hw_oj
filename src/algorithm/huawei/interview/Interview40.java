package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 40 解密犯罪时间
 * 解密规则为:利用当前出现过的数字，构造下一个距离当前时间最近的时刻
 * 每个出现数字都可以被无限次使用。
 * 最近的时刻可能在第二天。
 *  20:12得到20:20
 *  23:59得到22:22
 *  12:58得到15:11
 *  18:52得到18:55
 *  23:52得到23:53
 *  09:17得到09:19
 *  07:08得到08:00
 */
public class Interview40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(":");
        //存储每个元素
        ArrayList<Integer> list = new ArrayList<>();
        list.add(split[0].charAt(0)-'0');
        list.add(split[0].charAt(1)-'0');
        list.add(split[1].charAt(0)-'0');
        list.add(split[1].charAt(1)-'0');
        String h = split[0];
        String m = split[1];
        int H = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        ArrayList<Integer> all = new ArrayList<>();
        for(int a:list){
            for(int b : list){
                if(a <= 5)all.add(a * 10 + b);
            }
        }
        all.sort((a,b)->a-b);
        for(int a:all){
            if(a <= M)continue;
            if(a <10){
                System.out.println(h +":0"+a);
            }else{
                System.out.println(h +":"+a);
            }
            return;
        }
        if(H != 23){
            for(int a:all){
                if(a > H){
                    if(a < 10 && all.get(0)<10){
                        System.out.println("0"+a+":"+all.get(0));
                    }else if(a < 10){
                        System.out.println("0"+a+":"+all.get(0));
                    }else if(all.get(0)<10){
                        System.out.println(a+":0"+all.get(0));
                    }else{
                        System.out.println(a+":"+all.get(0));
                    }
                    return;
                }
            }
        }
        if(all.get(0) < 10){
            System.out.println("0"+all.get(0)+":0"+all.get(0));
        }else{
            System.out.println(all.get(0)+":"+all.get(0));
        }
    }
}
