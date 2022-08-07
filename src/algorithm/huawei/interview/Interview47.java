package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 工号不够用了怎么办?
 * 新的工号系统由小写英文字母(a-z)和数字 (0-9)两部分构成。
 * 新工号由一段英文字母开头，之后跟随一段数字，比如"aaahw0001","a12345","abcd1","a00"。
 * 新工号不能全为字母或者数字,允许数字部分有前导0或者全为0。
 * 是过⻓的工号会增加同事们的记忆成本，现在给出新工号至少需要分配的人数X和新工号中字母的⻓度Y，求新工号中数字的最短⻓度Z。
 */
public class Interview47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long X = scanner.nextLong();
        int Y = scanner.nextInt();
        int res = 1;
        int alp = (int) Math.pow(26,Y);
        while(alp * Math.pow(10,res) < X)res++;
        System.out.println(res);
    }
}
