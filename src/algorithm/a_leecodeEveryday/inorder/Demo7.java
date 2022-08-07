package algorithm.a_leecodeEveryday.inorder;
//7整数反转
public class Demo7 {
    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
    public static int reverse(int x) {
        if(x==0)return 0;
        int rev=0;

            while(x!=0){
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int a = x%10;
                rev = rev*10+a;
                x/=10;
            }
            return rev;

    }
}
