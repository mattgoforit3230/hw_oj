package algorithm.a_leecodeEveryday.sort;

public class SortTreesetDemo {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        TreeSet<String> set = new TreeSet<> ();
//        //借用api
//        for(int i=0;i<n;i++){
//            //首先把第一个输入的字符转为整型，然后分别得到第一个字符串，
//            //对第一个字符串解析，
//            String s = scan.next();
//            set.add(s);
//        }
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
        String s = "don't forget";
        System.out.println(reverseString(s));

        System.out.println("-------");
        String a = "adc";
        String b = "zzz";
        a = b;
        System.out.println(a);

        }

    public static  String reverseString(String s) {

        String[] split = s.split("\\s");
//        for(int i = 0;i<split.length;i++){
//            char[] chars = split[i].toCharArray();
//            int start = 0,end=chars.length-1;
//            while(start < end){
//                char temp = chars[start];
//                chars[start] = chars[end];
//                chars[end] = temp;
//                start++;
//                end--;
//            }
//            split[i] = String.valueOf(chars);
//        }
        for(String st:split){
            char[] chars = st.toCharArray();
            int start = 0,end=chars.length-1;
            while(start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            String newone= String.valueOf(chars);
            System.out.println("newone:"+newone);
            st = newone;
            System.out.println("st:"+st);
        }
        return String.join(" ",split);


    }
}
