package algorithm.a_leecodeEveryday.qianzhuiheAndChafen;

import java.util.HashMap;

public class Demo560 {
    //560. 和为K的子数组
    public int subarraySum(int[] nums, int k) {
        //前缀和,preSum[i]表示前0~i-1的和
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i = 1;i < nums.length+1;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            //map.put(k+preSum[i],map.getOrDefault(k+preSum[i],0)+1);
            if(map.containsKey(k+preSum[i])){
                res+= map.get(k+preSum[i]);
            }
            map.put(k+preSum[i],map.getOrDefault(k+preSum[i],0)+1);
        }
        return res;
    }
}
