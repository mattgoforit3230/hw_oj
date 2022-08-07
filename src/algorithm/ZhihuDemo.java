package algorithm;
import java.util.*;
public class ZhihuDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int i = demo1(sc.nextLine());
//            System.out.println(i);
//        }
        String s = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(demo2(s,c));
    }
    /**
     * 1、需求：计算字符串最后一个单词的长度，单词以空格隔开。
     * 输入描述：一行字符串，非空，长度小于5000。q输出描述: 整数N，最后一个单词的长度。
     */
    public static int demo1(String s){
//        String[] split = s.split("\\s+");
//        return split[split.length-1].length();

        //indexOf后面要用字符串，不支持正则
        //其实这个indexof就是光标所在位置的字符长度，比如在最开始，indexof以及长度都为0，下面-1就是减的空格的长度
        int i = s.length()-1-s.lastIndexOf(" ");
        return i;
    }
    /**
     * 2、写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
     * 然后输出输入字符串中含有该字符的个数。不区分大小写。
     */
    public static int demo2(String str,char c){
        int count = 0;
        if(str != null && str.length() > 0){
            for(int i = 0;i < str.length();i++){
                //实现不区分大小写
                if(c == str.charAt(i)){
                    count++;
                }
            }
        }else{
            count = 0;
        }
        return count;
    }
    /**
     * 3、明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了
     * N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数
     * 去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
     * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
     */

}
