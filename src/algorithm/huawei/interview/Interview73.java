package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 敏感字段加密
 * 给定一个由多个命令字组成的命令字符串:
 * 1. 字符串⻓度小于等于127字节，只包含大小写字母、数字、下划线和偶数个双引号;
 * 2. 命令字之间以一个或多个下划线_进行分割;
 * 3. 可以通过两个双引号来""标识包含下划线_的命令字或空命令字(仅包含两个引双引号的命令字)双
 * 引号不会在命令字内部出现; 仅对指定索引的敏感字段进行加密，替换为*，并删除命令字前后多余的下划线_。
 * 如果无法找到指定索引的命令字，输出字符串ERROR。
 *
 *
 1 pasword_a12345678__timeout_100
 =》 pasword_*_timeout_100
4
 ei_wejfi_" "_jiwef_"wef_fe"_jiwelw_ew__jw
 => ei_wejfi_" "_jiwef_******_jiwelw_ew_jw
 */
public class Interview73 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int k = Integer.parseInt(scanner.nextLine().trim());
        String[] split = str.split("_+");
        String s = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(split[i].startsWith("\"") && split[i].endsWith("\"")){
                list.add(split[i]);
            }else if(split[i].startsWith("\"")){
                s = split[i] + "_";
            }else if(split[i].endsWith("\"")){
                s += split[i];
                list.add(split[i]);
                s = "";
            }else{
                if(s.length() == 0){
                    list.add(split[i]);
                }else{
                    s += split[i] + "_";
                }
            }
        }
        StringBuilder res = new StringBuilder();
        if(k >= list.size()){
            System.out.println("ERROR");
        }else {
            for (int i = 0; i < list.size(); i++) {
                if (i==k) {
                    res.append("******");
                } else {
                    res.append(list.get(i));
                }
                res.append("_");
            }
            System.out.println(res.substring(0, res.length() - 1));
        }
    }
}
