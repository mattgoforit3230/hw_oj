package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 45 单词接⻰
 * 规则：
 *   可用于接⻰的单词首字母必须要前一个单词的尾字母相同;
 *
 *   当存在多个首字母相同的单词时，取⻓度最⻓的单词，如果⻓度也相等，则取字典序最小的单词;
 *   已经参与接⻰的单词不能重复使用。
 *   现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接⻰，
 *   请输出最⻓的单词串，单词串是单词拼接而成，中间没有空格。
 *输出：
 *   输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ;
 *   输入的第二行为一个非负整数，表示单词的个数N;
 *   接下来的N行，分别表示单词数组中的单词。
 4
 6
 word
 dd
 da
 dc
 dword
 d
 =>dwordda
 0
 6
 word
 dd
 da
 dc
 dword
 d
 =>worddwordda
 */
public class Interview45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine().trim());
        int N = Integer.parseInt(scanner.nextLine().trim());
        StringBuilder res = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(i == K){
                res.append(scanner.nextLine().trim());
            }else {
                list.add(scanner.nextLine().trim());
            }
        }
        while(true){
            TreeSet<String> set = new TreeSet<String>((a,b)->{
                if(a.length() != b.length())return b.length() - a.length();
                else {
                    for(int i = 0;i < a.length();i++){
                        if(a.charAt(i) != b.charAt(i)){
                            return a.charAt(i) - b.charAt(i);
                        }
                    }
                    return -1;
                }
            });
            String start = res.substring(res.length()-1,res.length());
            for(String s:list){
                if(s.startsWith(start)){
                    set.add(s);
                }
            }
            if(set.size() == 0){
                System.out.println(res);
                break;
            }
            String next = set.first();
            list.remove(next);
            res.append(next);
        }
    }
}
