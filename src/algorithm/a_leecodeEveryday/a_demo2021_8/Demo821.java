package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo821 {
    public static void main(String[] args) {
        //,'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'
        char[] chars = new char[]{'a','a','a','b','b','a','a','a'};
        System.out.print(compress(chars));
    }
    /**
     *给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     *
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     *
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     */
    public static char[] compress(char[] chars) {
        //双指针
        int write = 0;
        int end = 0;
        for (int read = 0; read < chars.length; read++) {
            int length = read-end+1;
            //读指针指向子串的最右端，或者最大长度，就进行写入
            if(read == chars.length-1 || chars[read+1]!=chars[read]){
                end = read+1;
                chars[write++] = chars[read];
                if(length > 1){
                    String s = String.valueOf(length);
                    for (int i = 0; i < s.length(); i++) {
                        chars[write++] = String.valueOf(length).charAt(i);
                    }
                }
            }
        }
        return chars;
    }
}
