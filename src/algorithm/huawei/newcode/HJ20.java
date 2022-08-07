package algorithm.huawei.newcode;
import java.util.*;

public class HJ20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(check(s));
        }
    }

    private static String check(String s) {
        if(s.length() < 8) return "NG";
        int[] flag = new int[4];
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if (cur - '0' >= 0 && cur - '0' <= 9) flag[0] = 1;
            else if (cur - 'a' >= 0 && cur - 'a' <= 25) flag[1] = 1;
            else if (cur - 'A' >= 0 && cur - 'A' <= 25) flag[2] = 1;
            else if (cur == ' ') return "NG";
            else {
                flag[3] = 1;
            }
            if (i > 1) {
                if (set.contains(s.substring(i - 2, i + 1))) {
                    return "NG";
                } else {
                    set.add(s.substring(i - 2, i + 1));
                }
            }
        }
        if(Arrays.stream(flag).sum() < 3)return "NG";
        return "OK";
    }
}
