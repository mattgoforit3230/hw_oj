package algorithm.a_leecodeEveryday.a_demo2021_9;

public class Demo910 {
    public static void main(String[] args) {
        chalkReplacer(new int[]{5,1,5},22);
    }
    public static int chalkReplacer(int[] chalk, int k) {
        long[] sums = new long[chalk.length];
        long sum = 0;
        for(int i = 0;i < chalk.length;i++){
            sum += chalk[i];
            sums[i] = sum;
        }
        int res = 0;
        long temp = k % sums[chalk.length-1];
        for(int i = 0;i < chalk.length;i++){
            if(sums[i] > temp)res = i;
        }
        return res;
    }
}
