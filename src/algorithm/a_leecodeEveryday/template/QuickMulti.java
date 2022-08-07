package algorithm.a_leecodeEveryday.template;
import java.util.*;

public class QuickMulti {
    public static void main(String[] args) {



    }
    static long mul(long a, long k) {
        long res = 0;
        while(k > 0){
            if((k & 1) == 1)res += a;
            k >>= 1;
            a += a;
        }
        return res;
    }

   
    

}
