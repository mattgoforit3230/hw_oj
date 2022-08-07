package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo829 {

    private static int res;
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }

    //1588. 所有奇数长度子数组的和
    public static int sumOddLengthSubarrays(int[] arr) {
        //dfs

        dfs(arr,arr.length);
        return res;
    }

    private static void dfs(int[] arr, int length) {
        if(length<0)return;
        for (int k = 0; k <= arr.length-length; k++) {
            for (int i = k; i < length+k; i++) {
                res += arr[i];
            }
        }
        dfs(arr,length-2);
    }
}
