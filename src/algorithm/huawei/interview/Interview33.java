package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 字符串加密
 * 给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，
 * 加密方式是在每 一个字母str[i]偏移特定数组元素a[i]的量，
 * 97-122
 * 数组a前三位已经赋值:a[0]=1,a[1]=2,a[2]=4。
 * 当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。
 * 例如:原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
 */
public class Interview33 {
    public static void main(String[] args) {
        //System.out.println((char)('z'+ 1 - 123 + 'a'));

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        int[] offset = new int[50];
        offset[0] = 1;
        offset[1] = 2;
        offset[2] = 4;
        for(int i = 3;i < 50;i++){
            offset[i] = offset[i-1] + offset[i-2] + offset[i-3];
        }
        for(int i = 0;i < N;i++){
            String s = scanner.nextLine().trim();
            StringBuilder res = new StringBuilder();
            for(int j = 0;j < s.length();j++){
                char cur = s.charAt(j);
                if(cur + offset[j] > 122){
                     cur = (char)((cur + offset[j] - 123)%26 + 'a');
                }else{
                    cur = (char)(cur + offset[j]);
                }
                res.append(cur);
            }
            System.out.println(res);
        }
    }
}
