package algorithm.a_leecodeEveryday.a_demo2021_8;

public class Demo823 {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }
    /**
     * 1646. 获取生成数组中的最大值
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     *
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大 值。
     */
    public static int getMaximumGenerated(int n) {
        int[] ints = new int[n + 1];
        int res = 0;
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++) {
            if (i % 2 == 1) {
                ints[i] = ints[i/2]+ints[i/2+1];
            } else {
                ints[i] = ints[i/2];
            }
            res = Math.max(res,ints[i]);
        }
        return res;
    }
}
