package algorithm.a_leecodeEveryday.sort;

public class    SortArrayListDemo {
    public static void main(String[] args) {

        int[] arr={-23,-3,-2,-1,0,3,5,9,12};
        //System.out.println(search(arr,2));
        int[] ints = sortedSquares(arr);
        for (int a:ints
             ) {
            System.out.print(a + " ");
        }

    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 示例 1：这个题做了2个小时，归并那里一直迷糊，。。。
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int pivot=-1;
        //判断是否为负数，负数段需要重新插入数组
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                //怎么找正负节点
                pivot = i;
            }
        }
        int[] arr = new int[nums.length];
        int m = pivot,n=pivot+1,i=0;
        //这里逻辑混乱了，若要从小到大从负数组里找最小值，从正数组找出最小值，进行对比，最小大进入新数组
        // 就类似于合并两个数组【归并算法】
        while(m >= 0 && n < nums.length && i < arr.length){
            arr[i++] = (int) (Math.pow(nums[m],2) < Math.pow(nums[n],2)?Math.pow(nums[m--],2):Math.pow(nums[n++],2));
        }
        if(m<0){
            for(int j = i;j < arr.length;j++){
                arr[j] = (int)Math.pow(nums[j],2);
            }
        }else if(n == nums.length){
            for(int j = i;j < arr.length;j++){
                arr[j] = (int) Math.pow(nums[arr.length -1-j],2);
            }
        }
        return arr;
    }
}
