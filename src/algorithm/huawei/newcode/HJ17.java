package algorithm.huawei.newcode;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splits = s.split(";");
        int x = 0,y = 0;
        for(String split : splits){
            if(check(split)){
                int temp = Integer.parseInt(split.substring(1,split.length()));
                if('A' == split.charAt(0)){
                    x -= temp;
                }else if('S' == split.charAt(0)){
                    y -= temp;
                }else if('W' == split.charAt(0)){
                    x += temp;
                }else{
                    y += temp;
                }
            }
        }
        System.out.println(x +","+y);
    }

    private static boolean check(String s) {
        if(s == null || s.length() == 0)return false;
        char head = s.charAt(0);
        if(head != 'A' && head != 'S' && head != 'W' && head != 'D')return false;
        for(int i = 1;i < s.length();i++){
            int temp = s.charAt(i) - '0';
            if(temp < 0 || temp > 9)return false;
        }
        return true;
    }
}
