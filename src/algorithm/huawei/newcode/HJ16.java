package algorithm.huawei.newcode;

import java.util.*;

/**
 * 金明的购物单，有依赖的背包，
 */
public class HJ16 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[][] nums = new int[m][4];

        for(int i = 0;i < m;i++){
            String temp = sc.nextLine();
            nums[i][0] = Integer.parseInt(temp.split(" ")[0]);
            nums[i][1] = Integer.parseInt(temp.split(" ")[1]);
            nums[i][2] = Integer.parseInt(temp.split(" ")[2]);
            nums[i][3] = i;
        }
        boolean[] isUsed = new boolean[m+1];
        Arrays.sort(nums,(a,b)->a[2]-b[2]);
        dfs(0,0,0,N,nums,isUsed);
        System.out.println(res);
    }
    public static void dfs(int cur, int sum,int sa, int N,int[][] nums,boolean[] isUsed){
        //if(cur >= nums.length|| nums[cur][2]!=0 && !isUsed[nums[cur][2]] || sum+nums[cur][0] > N)return;
        if(cur >= nums.length)return;
        dfs(cur+1,sum,sa,N,nums,isUsed);

        if(nums[cur][2]!=0 && !isUsed[nums[cur][2]])return;
        //if(sum+nums[cur][0] > N)return;
        if(cur == nums.length-1){

            //res = Math.max(res,sa + nums[cur][1] *nums[cur][0]);
            if(sa + nums[cur][1] *nums[cur][0] > res){
                res = sa + nums[cur][1] *nums[cur][0];
                System.out.println(cur);
            }
            return;
        }

        isUsed[nums[cur][3]+1] = true;
        dfs(cur+1,sum+nums[cur][0],sa + nums[cur][1] *nums[cur][0],N,nums,isUsed);
        isUsed[nums[cur][3]+1] = false;

    }
}








