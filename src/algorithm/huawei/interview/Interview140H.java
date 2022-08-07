package algorithm.huawei.interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

/**
 没有回文串
 ■ 题目描述

 【没有回文串】

 回文串的定义：正读和反读都一样的字符串现在已经存在一个不包含回文串的字符串，字符串的字符都是在英语字母的前N个,且字符串不包含任何长度大于等于2的回文串；请找出下一个字典序的不包含回文串的、字符都是在英语字母的前N个、且长度相同的字符串。如果不存在，请输出NO。

 输入描述

 输入包括两行。

 第一行有一个整数:N（1<=N<=26），表示字符串的每个字符范围都是前N的英语字母。

 第二行输入一个字符串（输入长度<=10000），输入保证这个字符串是合法的并且没有包含回文串。

 输出描述

 输出下一个字典序的不包含回文串的、字符都是在英语字母的前N个、且长度相同的字符串；

 如果不存在,请输出”NO“。

 示例1

 输入

 3

 cba

 输出

 NO
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * DFS找最短路线
 int maze[5][5] = {
 0,1,0,0,0
 0,1,1,1,0
 0,0,0,0,0
 0,1,1,1,0
 0,0,0,1,0
 };
 */
public class Interview140H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        sc.nextLine();
        String[] guzhang = sc.nextLine().split(",");

        List<String[]> list = new ArrayList<>();    //依赖关系集合
        List<String> listS = new ArrayList<>();     //所有服务集合
        List<String> listGZ = Arrays.asList(guzhang);   //故障集合
        for(int i=0;i<strings.length;i++){
            list.add(strings[i].split("-"));
            String a = strings[i].split("-")[0];
            String b = strings[i].split("-")[1];
            if(!listS.contains(a)){
                listS.add(a);
            }
            if(!listS.contains(b)){
                listS.add(b);
            }
        }

        for(int i=0;i<listGZ.size();i++){
            listS.remove(listGZ.get(i));    //将故障服务从所有服务中剔除
        }
        List<String> listZC = new ArrayList<>();    //保持正常的服务
        for(int i=0;i<listS.size();i++){
            String x = listS.get(i);    //此时的服务
            if(!isGz(list,x,listGZ)){      //如果非故障则取出
                listZC.add(x);
            }
        }

        int len = listZC.size();
        if(len==0){
            System.out.println(",");
        }else {
            String res = "";
            for(int i=0;i<len;i++){
                res+=listZC.get(i);
                if(i!=len-1){
                    res+=",";
                }
            }
            System.out.println(res);
        }
    }
    //服务依赖关系集合，需要判断的服务，故障服务集合
    public static boolean isGz(List<String[]> l,String s,List<String> gz){
        if(gz.contains(s)){ //此时服务故障则返回true
            return true;
        }
        for(int i=0;i<l.size();i++){
            //如果此时服务依赖另外一个服务，则对依赖的服务进行一次故障判断，
            // 如为故障则返回true
            if(l.get(i)[0].equals(s) && isGz(l,l.get(i)[1],gz)){
                return true;
            }
        }
        return false;
    }

}