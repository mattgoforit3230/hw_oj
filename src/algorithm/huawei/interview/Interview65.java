package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 考古问题
 3
 a b a
 =>
 aab
 aba
 baa
 */
public class Interview65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<List<String>> lists = new ArrayList<List<String>>();
        boolean[] isUsed = new boolean[N];
        dfs(lists,list,isUsed,split);
        ArrayList<String> res = new ArrayList<>();
        for(List<String> l : lists){
            String join = String.join("", l);
            res.add(join);
        }
        res.sort((a,b)->a.compareTo(b));
        res.stream().forEach(System.out::println);
    }

    private static void dfs(ArrayList<List<String>> lists, ArrayList<String> list,
                            boolean[] isUsed, String[] split) {
        if(list.size() == split.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            if(isUsed[i] || set.contains(split[i]))continue;
            list.add(split[i]);
            isUsed[i] = true;
            set.add(split[i]);
            dfs(lists,list,isUsed,split);
            isUsed[i] = false;
            list.remove(list.size()-1);
        }
    }
}
