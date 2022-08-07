package algorithm.a_leecodeEveryday._again.dp;

public class Demo912 {
    int res = Integer.MAX_VALUE;int temp = 0;
    public static void main(String[] args) {
        //"(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
        System.out.println(checkValidString(
                "(*()))*("));
    }
    //678. 有效的括号字符串
    //缺一个动态规划
    //"(*)("
    public static boolean checkValidString(String s) {
        int[] dx = {0,1,-1,0,1,-1,1,-1};
        int[] dy = {1,0,0,-1,1,-1,-1,1};
//        int sub = 0;
//        int counter = 0;
//        for(int i = 0;i < s.length();i++){
//            if('(' == s.charAt(i))counter++;
//            if(')' == s.charAt(i))counter--;
//            if('*' == s.charAt(i))sub++;
//            if(counter+sub < 0)return false;
//        }
//        System.out.println(counter);
//        System.out.println(sub);
//        System.out.println(counter-sub<=0);
//        if(counter > 0)return counter-sub<=0;
//        //if(counter < 0)return counter==sub*(-1);
//        return true;
        int counter = 0;
        System.out.println(s.length());
        int sub = 0,left_sub = 0,not_right = 0;
        for(int i = 0;i < s.length();i++) {
            if ('(' == s.charAt(i)) counter++;
            if (')' == s.charAt(i)) counter--;
            if ('*' == s.charAt(i)) sub++;
            if (counter == 0) {
                left_sub += sub;
                sub = 0;
            }
            if(counter+left_sub < sub)not_right = Math.max(not_right,sub-counter-left_sub);
            System.out.println("新增\'"+s.charAt(i)+"\' 后，counter = "+counter +";sub = "+sub+",left_sub = "+left_sub+",not_right = "+not_right);
            if(counter+sub+left_sub < 0){
                System.out.println(i);
                System.out.println(counter);
                System.out.println(sub);
                System.out.println(left_sub);
                return false;
            }
        }
        System.out.println("最终counter = "+counter);
        System.out.println("最终sub = "+sub);
        System.out.println("最终left_sub = "+left_sub);
        System.out.println("最终not_right = "+not_right);
        if(counter == 0)return true;
        if(counter > 0){
            if(counter+not_right-sub<= 0){
                return true;
            }else{
                return counter+left_sub+not_right-sub<=0;
            }
        }
        return true;

    }
}
