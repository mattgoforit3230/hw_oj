package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 素数之积
 *  RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全 系数越高。
 * 给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
 *  一个正整数num
 * 0 < num <= 2147483647
 * 如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1。
 2147483647
 -1 -1
 */
public class Interview113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fun(n);
    }
    public static void fun(int n){
        for (long i = 2; i*i <= n ; i++) {
            if(n % i == 0 && isPrime((int)i) && isPrime((int)(n / i))){
                int sum = (int) (n / i + i),max = (int) Math.max(n/i,i);
                System.out.println(sum-max+" "+max);
                return;
            }
        }
        System.out.println(-1+" "+-1);
    }
    public static boolean isPrime(int n){
        if(n <= 1)return false;
        if(n == 2)return true;
        if((n & 1) == 0)return false;
        for (int i = 3; i*i <= n ; i+=2) {
            if(n % i == 0)return false;
        }
        return true;
    }

//        Scanner sc = new Scanner(System.in);
//        long num = sc.nextLong();
//        long limit = (long) Math.floor(Math.sqrt(num));
//        String res = "";
//        boolean flag = false;
//        for (long i = 2; i <= limit; i++) {
//            if (num % i == 0) {
//                if (isPrime(i) && isPrime(num / i)) {
//                    flag = true;
//                    if (i < num / i) {
//                        res = i + " " + num / i;
//                    } else {
//                        res = num / i + " " + i;
//                    }
//                }
//            }
//        }
//        if (flag) {
//            System.out.println(res);
//        } else {
//            System.out.println("-1 -1");
//        }
//    }
//    public static boolean isPrime(long num) {
//        long limit = (long) Math.floor(Math.sqrt(num));
//        for (long i = 2; i <= limit; i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }
}
