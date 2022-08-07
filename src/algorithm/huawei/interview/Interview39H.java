package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
  [简易内存池]
 请实现一个简易内存池,根据请求命令完成内存分配和释放。
 内存池支持两种操作命令，REQUEST和RELEASE，其格式为:
 REQUEST=请求的内存大小 表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址;
       如果内存不足，或指定的大小为0，则输出error。
 RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
 5
 REQUEST=10
 REQUEST=20
 RELEASE=0
 REQUEST=20
 REQUEST=10

 8
 REQUEST=10
 REQUEST=19
 RELEASE=10
 RELEASE=9
 REQUEST=11
 REQUEST=52
 RELEASE=20
 RELEASE=19
 */
public class Interview39H {
    private static TreeMap<Integer,Integer> map = new TreeMap<>();
    public static int start = 0;
    public static int end = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine().trim();
        }
        for (int i = 0; i < n; i++) {
            String[] split = strings[i].split("\\=");
            if(split[0].equals("REQUEST")){
                request(Integer.parseInt(split[1]));
            }else{
                release(Integer.parseInt(split[1]));
            }
        }
    }
    private static void release(int num) {
        if(map.containsKey(num)){
            map.remove(num);
        }else{
            System.out.println("error");
        }
    }


    private static void request(int num) {
        if(num <= 0 || num >100){
            System.out.println("error");
            return;
        }
        if(map.isEmpty()){
            map.put(start,num);
            System.out.println(start);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                if(list.get(0)-start >= num) {
                    map.put(start, num);
                    System.out.println(start);
                    return;
                }
            }else if(list.get(i) - list.get(i-1) - map.get(list.get(i-1)) >= num){
                map.put(list.get(i-1) + map.get(list.get(i-1)),num);
                System.out.println(list.get(i-1) + map.get(list.get(i-1)));
                return;
            }
        }
        if(end - list.get(n-1) - map.get(list.get(n-1)) >= num){
            map.put(list.get(n-1) + map.get(list.get(n-1)),num);
            System.out.println(list.get(n-1) + map.get(list.get(n-1)));
        }else{
            System.out.println("error");
        }
    }
}
