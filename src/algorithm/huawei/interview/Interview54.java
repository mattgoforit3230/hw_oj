package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 英文输入法
 * 实现英文输入法单词联想功能。
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列
 * 如果联想不到，请输出用户输入的单词前缀。
 *注意：
 * 区分大小写
 * 缩略形式如"don't"，判定为两个单词，"don"和"t"
 * 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 *
 * 输入：
 *  输入为两行。
 *  首行输入一段由英文单词word和标点符号组成的语句str;
 *  接下来一行为一个英文单词前缀pre。
 */
public class Interview54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().trim();
        String[] split = word.split("[^a-zA-Z]+");
        ArrayList<String> list = new ArrayList<>();
        String pre = scanner.nextLine().trim();
        for(String s:split){
            if(s.startsWith(pre))list.add(s);
        }
        System.out.println(String.join(" ",list));
    }
}
