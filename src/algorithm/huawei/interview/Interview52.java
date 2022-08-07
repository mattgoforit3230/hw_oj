package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 找⻋位
 * 停⻋场有一横排⻋位，0代表没有停⻋，1代表有⻋。至少停了一辆⻋在⻋位上，也至少有一个空位没 有停⻋。
 1000101010 2
 1000000000 9
 1000
 3
 0001
 3
 0000000001 9
 1000000001 4
 0000000000 9
 =>10
 000
 2

 也可以用1分割字符串，再分别考虑首位为0，尾部为0，全为0的情况
 */
public class Interview52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(",");
        int count = 0,max = 0,res = 0;
        boolean start = false;
        for (int i = 0; i < split.length; i++) {
            char cur = split[i].charAt(0);
            if(cur == '1'){
                if(!start){
                    //max = count * 2;
                    max = count;
                    start = true;
                }else{
                    max = count + 1 >> 1;
                    //max = Math.max(max,count);
                }
                count = 0;
                res = Math.max(res,max);
            }else{
                count++;
            }
        }
        if(split[split.length-1].charAt(0) == '0'){
            //1000000
            if(start){
                res = Math.max(count,res);
            }else{
                //00000
                res = Math.max(count,res);
            }
            //max = Math.max(max,count * 2);
        }else{
            //max = Math.max(max,count);
        }
        System.out.println(res);
    }
}
