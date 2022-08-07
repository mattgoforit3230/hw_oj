package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 42 报数游戏
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100。
 * 他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余 的人数小于M。
 * 请问最后剩余的人在原先的编号为多少?
 */
public class Interview42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        if(M <= 1 || M >= 100) {
            System.out.println("ERROR!");
        }else {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                list.add(i+"");
            }
            int index = 0;
            while(list.size() >= M){
                index = (index + M - 1)%list.size();
                list.remove(index);
            }
            System.out.println(String.join(",",list));
        }
    }
}
