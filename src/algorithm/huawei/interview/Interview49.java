package algorithm.huawei.interview;

import java.util.Scanner;

/**
 * 整型数组按个位值排序
 * 给定一个非空数组(列表)，其元素数据类型为整型，请按照数组元素十进制最低位从小到大进
 *   行排序，十进制最低位相同的元素，相对位置保持不变。
 *   当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
 */
public class Interview49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(",");
        StringBuilder sb = new StringBuilder();
        for(char i = '0';i <= '9';i++){
            for(String cur:split){
                if(cur.charAt(cur.length()-1) == i){
                    sb.append(cur);
                    sb.append(",");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
