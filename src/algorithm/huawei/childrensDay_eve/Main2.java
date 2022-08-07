package algorithm.huawei.childrensDay_eve;

import java.util.Scanner;

/**
 a:3,b:5,c:2@a:1,b:2
 a:2,b:3,c:2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine().trim();
            String[] split = str.split("@");
            if (split.length == 1) {
                System.out.println(str);
                return;
            }
            String[] add = split[0].split(",");
            String[] sub = split[1].split(",");
            int[] nums = new int[84];
            int[] order = new int[add.length];
            for (int i = 0; i < add.length; i++) {
                char cur = add[i].charAt(0);
                order[i] = cur - 'A';
                nums[cur - 'A'] = Integer.parseInt(add[i].substring(2));
            }
            int sum = 0;
            for (int i = 0; i < sub.length; i++) {
                char cur = sub[i].charAt(0);
                sum += Integer.parseInt(sub[i].substring(2));
                nums[cur - 'A'] -= Integer.parseInt(sub[i].substring(2));
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < add.length; i++) {
                if (nums[order[i]] != 0) {
                    char cur = (char) (order[i] + 'A');
                    res.append(cur);
                    res.append(":");
                    res.append(nums[order[i]]);
                    res.append(",");
                }
            }

            if (sum != 0) System.out.println(res.substring(0, res.length() - 1));
            else System.out.println(res.substring(0, res.length() - 1) + "@");
        }
    }
}
