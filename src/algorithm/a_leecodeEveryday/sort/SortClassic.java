package algorithm.a_leecodeEveryday.sort;
import java.util.*;
/**
 * bubble,selection,insertion,shell,merge,quick,heap,bucket,radix
 */
public class SortClassic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int[] split = Arrays.asList(sc.nextLine().split("\\s+")).
//                    stream().mapToInt(Integer::parseInt).toArray();
//            quick(split);
//            for (int i:
//                 split) {
//                System.out.print(i+" ");
//            }
//        }
        int[] arr ={0,4,2,9,1,0,1,1,1,1,2,2,3,3,4,7};
        System.out.println("start");
        optimizeBubble(arr);
        for (int n:
                 arr) {
                System.out.print(n+" ");
            }
    }

    /**
     * 冒泡0o0o0o0o0000o0o0o
     * @param arr
     */
    public static void bubble(int[] arr){
        for (int i = arr.length; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                while(arr[j] > arr[j+1]){
                    swapArr(j,j+1,arr);
                }
            }
        }
    }

    /**
     * 冒泡优化，设置标志位，来判断有没有调用swapArr()
     * @param arr
     */
    public static void optimizeBubble(int[] arr){
        int n = arr.length;
        //true表示修改过
        boolean flag=true;
        while(flag && n>0){
            flag=false;
            for (int i = 0; i < n-1; i++) {
                if(arr[i] > arr[i+1]){
                    swapArr(i,i+1,arr);
                    flag=true;
                }
            }
            n--;
        }
    }


    /**快速排序
     * 错误有：
     * 1.未保留ij初始值
     * 2.边界未确定好，一共两类边界，分治的边界+ij逼index的边界
     * @param arr
     */
    public static void quick(int[] arr){
        //quickSort(arr,0,arr.length-1);
        quickSort2(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int start,int end){
        //需要一个start，留给分治的时候的未改变的值
        int i=start,j=end;
        if(i >= j){
            return;
        }
        int index = i,temp;
        while(j > i) {
            //分治这里有个递归，所以需要确定边界也就是最外层的while(j > i)
            // 确定的index时候，从两头分别向最终index逼近的时候也有两个边界
            while (j > i && arr[j] >= arr[index]) {
                j--;
            }
            if (j > i) {
                //swap(arr[j],arr[index]);
                temp = arr[j];
                arr[j] = arr[index];
                arr[index] = temp;
                index = j;
            }
            while (j > i && arr[i] <= arr[index]) {
                i++;
            }
            if (j > i) {
                /**
                 * ?????????????????
                 */
                //swap(arr[i],arr[index]);
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index = i;
            }
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }
    public static void quickSort2(int[] arr,int start,int end){
        if(start >= end){return;}
        int i=start,j=end,temp=arr[i];
        while(i < j){
            //从后往前找小于temp的，然后交换
            while(i < j && arr[j] > temp){
                j--;
            }
            if(i < j){
                arr[i++]=arr[j];
            }
            while(i < j && arr[i] < temp){
                i++;
            }
            if(i < j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        quickSort2(arr,start,i-1);
        quickSort2(arr,i+1,end);
    }

    /**
     *
     * @param arr
     */
    public static void selection(int[] arr){}
    /**
     *
     * @param arr
     */
    public static void insertion(int[] arr){}
    /**
     *
     * @param arr
     */
    public static void shell(int[] arr){}

    /**
     *适用于两个有序数组归并成一个数组时
     * @param arr
     */
    public static void merge(int[] arr){
        int start = 0,end = arr.length-1,mid=start+(end - start)/2;
        merge(arr,start,end);
    }
    public static void merge(int[] arr,int start,int end){
        int mid=start+(end - start)/2;
        while(start < end){
            merge(arr,start,mid);
            merge(arr,mid+1,end);
        }
        mergeSort(arr,start,mid,end);
    }
    private static void mergeSort(int[] arr, int start, int mid, int end) {
        
    }





    //其实是在新的数组上交换
    public static void swap(int n,int m){
        int temps=n;
        n=m;
        m=temps;
    }
    public static void swapArr(int n,int m,int[] arr){
        int temps=arr[n];
        arr[n]=arr[m];
        arr[m]=temps;
    }
}
