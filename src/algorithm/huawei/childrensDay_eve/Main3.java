package algorithm.huawei.childrensDay_eve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don't know that I love you.
 f
 front furthest

 I love you
 He
 He
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String word = scanner.nextLine().trim();
            String pre = scanner.nextLine().trim();
            String[] split = word.split("[^a-zA-Z]+");
            ArrayList<String> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            for (String s : split) {
                if (s.startsWith(pre) && !set.contains(s)) {
                    list.add(s);
                    set.add(s);
                }
            }
            list.sort((a, b) -> a.compareTo(b));
            if (list.size() == 0) System.out.println(pre);
            else System.out.println(String.join(" ", list));
        }
    }
}
