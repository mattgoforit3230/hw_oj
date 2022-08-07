package algorithm.a_leecodeEveryday.sort;

import java.util.*;

/**
 * 利用treemap排序功能（Interger大小，String字典排序）进行排序，可以自写比较器来进行自定义顺序
 */
public class SortTreemapDemo {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        treeMap.put("a","aa");
        treeMap.put("a","b");
        treeMap.put("b","aaa");
//        Set<String> strings = treeMap.keySet();
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()){
//            String a = iterator.next();
//            System.out.println(a+","+treeMap.get(a));
//        }
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, String> m:
             list) {
            System.out.println(m.getValue());
        }

    }
}
