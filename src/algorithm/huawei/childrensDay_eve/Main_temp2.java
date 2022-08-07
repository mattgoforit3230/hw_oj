package algorithm.huawei.childrensDay_eve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**
 a:3,b:5,c:2@b:0
 a:3,b:5,c:2@
 a:3,b:5@b:5
 */
public class Main_temp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine().trim();
            System.out.println(fun(str));
        }
    }
    public static String fun(String str){
        if(str.length() == 0){
            return "@";
        }
        String[] split = str.split("@");
        if (split.length == 1) {
            return str;
        }
        String[] add = split[0].split(",");
        String[] sub = split[1].split(",");
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < add.length; i++) {
            char cur = add[i].charAt(0);
            int add_val = Integer.parseInt(add[i].substring(2));
            map.put(cur,map.getOrDefault(cur,0)+add_val);
            list.add(cur);
        }
        int sum = 0;
        for (int i = 0; i < sub.length; i++) {
            char cur = sub[i].charAt(0);
            int delete = Integer.parseInt(sub[i].substring(2));
            sum += delete;
            map.put(cur,map.get(cur)-delete);
        }
        StringBuilder res = new StringBuilder();
        for(char cur:list){
            if(map.get(cur)!=0){
                res.append(cur);
                res.append(":");
                res.append(map.get(cur));
                res.append(",");
            }
        }
        if(res.length() == 0)return "";
        if (sum != 0) {
            return res.substring(0, res.length() - 1);
        } else {
            return res.substring(0, res.length() - 1) + "@";
        }
    }
}
