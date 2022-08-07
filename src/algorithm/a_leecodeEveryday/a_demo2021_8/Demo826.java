package algorithm.a_leecodeEveryday.a_demo2021_8;

import java.util.Arrays;

public class Demo826 {
    public static void main(String[] args) {
        //[4,9,3,1,1,7,6,10,10,10,1,8,8,7,8,10,7,4,6,3,6,1,2,4,8,8,4,7,1,2,10,3,4,6,3,5,3,1,2,6,1,5,4,5,1,10,5,9,10,4]
        //10
        System.out.println(numRescueBoats(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},10));
    }
    //881. 救生艇
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res= 0;
        int light = 0,heavy = people.length-1;
        while(light <= heavy){
            if(people[light]+people[heavy] > limit){
                heavy--;
                res++;
            }else {
                heavy--;
                light++;
                res++;
            }
        }
        return res;
    }
}
