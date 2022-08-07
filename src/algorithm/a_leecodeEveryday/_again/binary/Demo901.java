package algorithm.a_leecodeEveryday._again.binary;

public class Demo901 {
    //34. 在排序数组中查找元素的第一个和最后一个位置
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{2,2},3));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0,right =nums.length;
        int a = binarySearch(left,right,nums,target);
        int b = binarySearch(left,right,nums,target+1);
        if(nums.length==0 || nums[a] != target)return new int[]{-1,-1};
        return new int[]{a,b-1};
    }

    //找到target的首个值
    private static int binarySearch(int left, int right, int[] nums, int target) {
        while (left <right) {
            int mid = (right + left) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
