package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * [最远足迹]
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录
 * 自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后，探险队需要获取到某成员在探险
 * 过程中相对于探险队总部的最远的足迹位置。
 * 1. 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。
 * 同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 2. 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为:x*x+y*y。
 * 3. 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 4. 若记录仪中的坐标都不合法，输出总部坐标(0,0)。
 */
public class Interview26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int max = 0;
        int l = -1,r = -1;
        String res = "(0,0)";
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(')l = i;
            else if(s.charAt(i) == ')') {
                r = i;
                if(l != -1){
                    String temp = s.substring(l+1, r);
                    String[] split = temp.split(",");
                    if(split.length == 2 && split[0].charAt(0)-'0'<= 9 &&
                            split[0].charAt(0)-'0'> 0){
                        int a = Integer.parseInt(split[0]);
                        int b = Integer.parseInt(split[1]);
                        if(max < a*a + b*b){
                            max = a*a + b*b;
                            res = s.substring(l, r+1);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
