package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 数列描述
 *  有一个数列a[N] (N=60)，从a[0]开始，每一项都是一个数字。数列中a[n+1]都是a[n]的描述。其中 a[0]=1。
 */
public class Interview105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String cur = "1";
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int num = 1;
            for (int j = 0; j < cur.length(); j++) {
                if(j != cur.length()-1 &&
                        cur.charAt(j)!=cur.charAt(j+1) ||
                        j == cur.length()-1){
                    temp.append(num);
                    temp.append(cur.charAt(j));
                    num = 1;
                }else {
                    num++;
                }
            }
            cur = temp.toString();
        }
        System.out.println(cur);
    }
}
