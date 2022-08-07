package algorithm.a_leecodeEveryday.a_demo2021_9;

import java.util.Arrays;

public class Demo903 {
    public static void main(String[] args) {
        int[] ints = smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for (int a:ints
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    //面试题 17.14. 最小K个数
    public static int[] smallestK(int[] arr, int k) {
       //快排
        quickSort(arr,0,arr.length-1,k);
        return Arrays.copyOfRange(arr,0,k);
    }

    private static void quickSort(int[] arr, int start, int end, int k) {
        if(end<=start)return;
        int i = start,j = end,pivot = arr[start];
        while(i < j){
            while(arr[j] > pivot && i < j){
                j--;
            }
            if(i < j){
                arr[i++] = arr[j];
            }
            while(arr[i] < pivot && i < j){
                i++;
            }
            if(i < j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot;
        if(i-start+1 > k)quickSort(arr,start,i-1,k);
        if(i-start+1 == k)return;
        if(i-start+1 < k)quickSort(arr,i+1,end,k-i+start-1);
    }
}
