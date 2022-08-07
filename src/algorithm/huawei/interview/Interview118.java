package algorithm.huawei.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 找出经过特定点的路径⻓度
 *  输入一个字符串，都是以大写字母组成，每个相邻的距离是 1，
 *  第二行输入一个字符串，表示必过的点。
 *  说明每个点可过多次。
 ANTSEDXQOKPUVGIFWHJLYMCRZB
 ABC
 =>28
 */
public class Interview118 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),i);
        }
        String s = scanner.nextLine().trim();
        int path = 0;
        int start = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int end = map.get(s.charAt(i));
            path += Math.abs(end - start);
            start = end;
        }
        System.out.println(path);
    }
}
