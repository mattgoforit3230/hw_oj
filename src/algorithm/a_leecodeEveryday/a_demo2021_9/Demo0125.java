package algorithm.a_leecodeEveryday.a_demo2021_9;
import java.util.*;

public class Demo0125 {
    public static void main(String[] args) {
        String s = "Marge, let's \"[went].\" I await {news} telegram.";
        String b = " \"[went].\"";
        String c = "[";
        for (int i = 0; i < c.length(); i++) {
            System.out.print(getallowed(c.charAt(i)) + " ");
        }
        //isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        if(s.length() == 1)return true;
        int left = 0,right = s.length()-1;
        while(left < right){
            char chl = getallowed(s.charAt(left));
            char chr = getallowed(s.charAt(right));
            if(chl != '&' && chr != '&' && left < right){
                System.out.println("chr : "+chr+" , chl : "+chl);
                System.out.println("left : "+left+" , right : "+right);
                if(chr != chl)return false;
                left++;
                right--;
                continue;
            }
             if(chl == '&')left++;
             if(chr == '&')right--;
        }
        return true;
    }
    public static Character getallowed(char ch){

        LinkedList<Object> objects = new LinkedList<>();

        if(ch -'0' >= 0 && ch - '0'<=9)return ch;
        //if(ch - 'a' >=0 && ch - 'a' <= 26)return ch;
        if(ch - 'a' >=0 && ch - 'a' < 26)return ch;
        if(ch - 'A' >=0 && ch - 'A' < 26)return (char)(ch+32);
        return '&';
    }
}
