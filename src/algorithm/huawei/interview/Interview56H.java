package algorithm.huawei.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 信道分配
 *第一行，一个数字 R。R为最大阶数。0<=R<20 第二行，R+1个数字，用空格隔开。 代表每种信道的数量 Ni。
 * 按照阶的值从小到大排列。 0<=i<=R,0<=Ni<1000.
 * 第三行，一个数字 D。 D为单个用户需要传输的数据量。0<D<1000000
 *
 5
 10 5 0 1 3 2
 30
 =>4
 */

public class Interview56H {
//        public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int R = Integer.parseInt(scanner.nextLine().trim());
//        //代表每种信道的数量 Ni。按照阶的值从小到大排列。
//        int[] nis = new int[R + 1];
//        String[] split = scanner.nextLine().trim().split("\\s+");
//        for (int i = 0; i < nis.length; i++) {
//            //每种信道的容量
//            nis[i] = Integer.parseInt(split[i]);
//        }
//        int D = Integer.parseInt(scanner.nextLine().trim());
//        int res = 0,end = R+1, sum = 0;
//        for (int i = R; i >= 1; i--) {
//            //信道容量
//            int ni = 2<<i;
//            if(ni >= D){
//                res += nis[i];
//                end = i;
//            }else{
//                sum += nis[i];
//            }
//        }
//        int l = 0,r = sum+1;
//        while(l < r){
//            int m = l + r>>1;
//            if(check(m,nis,D,end)){
//                l = m + 1;
//            }else{
//                r = m;
//            }
//        }
//        System.out.println(l-1+res);
//    }
//
//    private static boolean check(int users, int[] nis, int d,int end) {
//        nis[1] += nis[0] >> 1;
////        for (int i = end; i >= 1; i--) {
////            int ni = 2<<i;
////            if(nis[i] >= )
////        }
//        for (int i = 1; i < end; i++) {
//            if(nis[i] >= users){
//                nis[i+1]
//            }else{
//
//            }
//        }
//        return users<=0;
//    }



//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int R = Integer.parseInt(scanner.nextLine().trim()); // 最大阶数
//        String[] NiStrs = scanner.nextLine().trim().split(" ");
//        int[][] Nis = new int[R + 1][2]; // 每种信道的数量Ni。按照阶的值从小到大排列
//        for (int i = 0; i < Nis.length; i++) {
//            Nis[i][0] = (int) Math.pow(2, i);
//            Nis[i][1] = Integer.parseInt(NiStrs[i]);
//        }
//        int D = Integer.parseInt(scanner.nextLine()); // 单个用户需要传输的数据量
//        int count = 0;
//        Map<Integer, Integer> shizhi = new HashMap<>();
//        for (int[] ni : Nis) {
//            int Ni = ni[0];
//            int Ni_count = ni[1];
//
//            if (Ni_count == 0) {
//                continue;
//            }
//            if (Ni >= D) {
//                count += Ni_count;
//                continue;
//            }
//
//            int mo = D % Ni;
//            int shang = D / Ni;
//            int need_count = mo == 0 ? shang : shang + 1;
//
//            count += Ni_count / need_count;
//
//            // 剩余个数
//            int Ni_count_left = Ni_count - (Ni_count / need_count) * need_count;
//            if (shizhi.size() != 0) {
//                int temp = 0;
//                for (Map.Entry<Integer, Integer> en : shizhi.entrySet()) {
//                    temp += en.getKey() * en.getValue();
//                }
//                // 单个用户还剩多少数据量
//                int D_left = D - temp;
//                int mo_left = D_left % Ni;
//                int shang_left = D_left / Ni;
//                int need_count_left = mo_left == 0 ? shang_left : shang_left + 1;
//                if (Ni_count_left >= need_count_left) {
//                    shizhi.clear();
//                    count++;
//                    Ni_count_left -= need_count_left;
//                }
//            }
//            if (Ni_count_left > 0) {
//                shizhi.put(Ni, Ni_count_left);
//            }
//        }
//
//        System.out.println(count);
//    }


    private static final Map<Integer, Integer> map = new HashMap<>();
    static {
        int tempNum = 1;
        for (int i = 0; i < 21; i++) {
            map.put(i, tempNum);
            tempNum = tempNum << 1;
        }
    }
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            int[] jieList = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                jieList[i] = s.nextInt();
            }
            int num = s.nextInt();
            int lastWei = 0;
            for (int i = 1; i <= n; i++) {
                if (map.get(i) < num) {
                    lastWei++;
                } else {
                    break;
                }
            }
            int[] he = new int[n + 1];
            int total = 0;
            for (int i = lastWei + 1; i <= n; i++) {
                total += jieList[i];
            }
            while (true) {
                for (int i = 0; i <= lastWei; i++) {
                    he[i] = 0;
                }
                for (int i = 1; i <= lastWei; i++) {
                    he[i] = he[i - 1] + jieList[i] * map.get(i);
                }
                if (he[lastWei] >= num) {
                    recursion(jieList, num, he, lastWei);
                    total++;
                } else {
                    break;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void recursion(int[] jieList, int num, int[] he, int lastWei) {
        if (lastWei < 0)
            return;
        if (lastWei == 0) {
            if (he[lastWei] >= num) {
                jieList[lastWei] -= num;
            }
            return;
        }
        int min = Math.min(jieList[lastWei], num / (map.get(lastWei)));
        if (min * map.get(lastWei) == num) {
            jieList[lastWei] -= min;
        } else {
            if (he[lastWei - 1] >= num - min * map.get(lastWei)) {
                jieList[lastWei] -= min;
                recursion(jieList, num - min * map.get(lastWei), he, lastWei - 1);
            } else {
                jieList[lastWei] -= min + 1;
            }
        }
    }
}
