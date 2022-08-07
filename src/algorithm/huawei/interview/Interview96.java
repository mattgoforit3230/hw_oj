package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 磁盘容量排序
 *  磁盘的容量单位常用的有M，G，T这三个等级，它们之间的换算关系为1T = 1024G，1G = 1024M，
 *  现在给定n块磁盘的容量，请对它们按从小到大的顺序进行稳定排序，例如给定5块盘的容量，
 *  1T，20M，3G，10G6T，3M12G9M排序后的结果为20M，3G，3M12G9M，1T，10G6T。
 * 注意单位可以重复出现，上述3M12G9M表示的容量即为3M+12G+9M，和12M12G相等。
 *
 *  输入第一行包含一个整数n(2 <= n <= 100)，表示磁盘的个数，接下的n行，每行一个字符串(⻓度 大于2，小于30)，表示磁盘的容量，
 * 由一个或多个格式为mv的子串组成，其中m表示容量大小，v表示容量单位，例如20M，1T， 30G，10G6T，3M12G9M。
 * 磁盘容量m的范围为1到1024的正整数，容量单位v的范围只包含题目中提到的M，G，T三种，换算 关系如题目描述。
 *
 * 输出n行，表示n块磁盘容量排序后的结果。
 3
 1G
 2G
 1024M
 =》
 1G
 1024M
 2G

 5
 2G4M
 3M2G
 1T
 3M12G9M
 12M12G
 =>
 3M2G
 2G4M
 3M12G9M
 12M12G
 1T

 */
public class Interview96 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine().trim());
        }
        for(String temp:list){
            int sum = 0;
            int num = 0;
            for (int i = 0; i < temp.length(); i++) {
                char cur = temp.charAt(i);
                if(cur <= '9' &&  cur >= '0'){
                    num = num * 10 + cur-'0';
                }else if(cur == 'T'){
                    sum += num * 1024 * 1024;
                    num = 0;
                }else if(cur == 'G'){
                    sum += num * 1024;
                    num = 0;
                }else if(cur == 'M'){
                    sum += num;
                    num = 0;
                }
            }
            map.put(temp,sum);
        }
        list.sort((a,b)->map.get(a)-map.get(b));
        list.stream().forEach(System.out::println);
    }
}
