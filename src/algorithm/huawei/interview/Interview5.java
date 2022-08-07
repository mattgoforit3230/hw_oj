package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * TLV编码是按[Tag Length Value]格式进行编码的，一段码流中的信元用Tag标识，
 * Tag在码流中唯一 不重复，Length表示信元Value的⻓度，Value表示信元的值。
 * 码流以某信元的Tag开头，Tag固定占一个字节，Length固定占两个字节，字节序为小端序。
 * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的Value。
 * 输入码流的16机制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含小写字母;
 * 码 流字符串的最大⻓度不超过50000个字节。
 * 输入描述
 * 输入的第一行为一个字符串，表示待解码信元的Tag; 输入的第二行为一个字符串，
 * 表示待解码的16进制码流，字节之间用空格分隔。
 * 输出描述
 * 输出一个字符串，表示待解码信元以16进制表示的Value。
 *  31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * => 32 33
 */
public class Interview5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Tag = scanner.nextLine();
        String s = scanner.nextLine();
        String[] splits = s.split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        int tag = 0;
        while(tag < splits.length){
            int len = Integer.parseInt(splits[tag+1]) + Integer.parseInt(splits[tag+2])*100;
            if(splits[tag].equals(Tag)){
                for(int j = tag + 3;j < len +tag + 3;j++){
                    list.add(splits[j]);
                }
            }
            tag += len + 3;
        }
        System.out.println(String.join(" ", list));
        //网上答案
//        Scanner sc = new Scanner(System.in);
//        String tag = sc.nextLine();
//        String[] split = sc.nextLine().split("\\s+");
//
//        for(int i=0; i<split.length; ){
//            int len = Integer.parseInt(split[i+2]+split[i+1],16);
//            if(tag.equals(split[i])){
//                StringBuilder bu = new StringBuilder();
//                for(int j=i+3; j<i+3+len;j++){
//                    bu.append(split[j]).append(" ");
//                }
//                System.out.println(bu.toString());
//                break;
//            }
//            else{
//                i+=len+3;
//            }
//        }
    }

}
