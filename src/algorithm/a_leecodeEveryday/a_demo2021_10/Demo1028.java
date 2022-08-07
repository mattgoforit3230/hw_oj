package algorithm.a_leecodeEveryday.a_demo2021_10;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.*;

public class Demo1028 {
    public static void main(String[] args) {

//        String s = "00 99 3r";
//        //String[] split = s.split(" ");
//        String[] strings = testArray(s);
//        System.out.println(strings[0]);
        //if(!(0 % 2 == 0 ^ 5 % 2 == 0)) System.out.println(false);
        String s = "abc";

        ArrayList<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList<Integer>().add(2,5));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2,5);
        res.add(list);


    }
    public static String[] testArray(String s){
        String[] split = s.split(" ");
        List<String> list = Arrays.asList(split);
        return (String[]) list.toArray();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums2.length - 1; i >= 0;i--){
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
                stack.push(nums2[i]);
                continue;
            }
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
        }
        int[] res = new int[nums1.length];
        for(int i = 0;i < res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
