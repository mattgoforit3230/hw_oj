package algorithm.huawei.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [30 最大花费金额]（最接近的三数之和）o(n2)
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定
 * 从众多心仪商品中购买三件，而且想尽可能的花完资金，现在请你设计一个程序帮助小明计算尽可能花
 * 费的最大资金数额。
 * 输入描述:
 * 输入第一行为一维整型数组M，数组⻓度小于100，数组元素记录单个商品的价格，单个商品价格 小于1000。
 * 输入第二行为购买资金的额度R，R小于100000。
 * 输出描述:
 *   输出为满足上述条件的最大花费额度。
 * 注意:
 * 如果不存在满足上述条件的商品，请返回-1。
 */
public class Interview30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = s.split(",");
        int n = split.length;
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        int target = scanner.nextInt();
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        if(res > target){
            System.out.println(-1);
            return;
        }
        for(int i = 0;i < n;i++){
            int l = i + 1,r = n-1;
            while(l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp > target){
                    r--;
                }else {
                    res = Math.max(temp,res);
                    l++;
                }
            }
        }
        System.out.println(res);
    }
}
