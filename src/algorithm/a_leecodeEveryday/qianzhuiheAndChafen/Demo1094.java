package algorithm.a_leecodeEveryday.qianzhuiheAndChafen;

public class Demo1094 {
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}},4));
    }
    //差分
    //1094. 拼车
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] ints = new int[50];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2] ; j++) {
                ints[j] += trips[i][0];
                if(ints[j] > capacity)return false;
            }
        }
        return true;
    }
}
