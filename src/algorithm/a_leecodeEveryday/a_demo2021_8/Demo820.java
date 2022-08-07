package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo820 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        int index = 0;
        StringBuffer sb = new StringBuffer(s);
            while(sb.length()-index >= 2*k){
                int start = index;
                int end = start+k-1;
                while(start < end){
                    char temp = sb.charAt(start);
                    sb.setCharAt(start,sb.charAt(end));
                    sb.setCharAt(end,temp);
                    start++;
                    end--;
                }
                index += 2* k;
            }
            if(s.length()-index >= k){
                int start = index;
                int end = start+k-1;
                while(start < end){
                    char temp = sb.charAt(start);
                    sb.setCharAt(start,sb.charAt(end));
                    sb.setCharAt(end,temp);
                    start++;
                    end--;
                }
            }else{
                int start = index;
                int end = sb.length()-1;
                while(start < end){
                    char temp = sb.charAt(start);
                    sb.setCharAt(start,sb.charAt(end));
                    sb.setCharAt(end,temp);
                    start++;
                    end--;
                }
            }

        return sb.toString();
    }


}
