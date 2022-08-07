package algorithm.huawei.interview;

//import java.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Interview12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("\\s+");
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < split.length;i++){
            if(set.contains(split[i].toLowerCase()))continue;
            else{
                set.add(split[i].toLowerCase());
                list.add(split[i]);
            }
        }
        list.sort((a,b)->{
            a = a.toLowerCase();
            b = b.toLowerCase();
            int n = a.length(),m = b.length();
            for(int i = 0;i < Math.min(n,m);i++){
                if(a.charAt(i) != b.charAt(i))return a.charAt(i) - b.charAt(i);
            }
            return n-m;
        });
        System.out.println(String.join(" ",list));
    }
}
