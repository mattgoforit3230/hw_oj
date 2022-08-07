package algorithm.huawei.interview;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 【字符统计及重排】
 *   给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母(区分大小写)出现的次
 *   数，
 *   并按照字母出现次数从大到小的顺序。输出各个字母及其出现次数。
 *   如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 */
public class Interview21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println('a'>=97);
        String str = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>((a,b)->{
            if(a<97 && b >= 97)return b-a;
            else if(a >= 97 && b < 97)return b-a;
            //else if(b-a>=32)return a-b;
            else return a-b;
        });
        char[] chars = str.toCharArray();
        for(char cur:chars)map.put(cur,map.getOrDefault(cur,0) + 1);
        StringBuilder res = new StringBuilder();
        //Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            res.append(entry.getKey());
            res.append(":");
            res.append(entry.getValue());
            res.append(",");
        }
        System.out.println(res.substring(0,res.length()-1));

    }
}
