package algorithm.a_leecodeEveryday._again.binary;

public class Demo033 {
    //33. 搜索旋转排序数组
    public static void main(String[] args) {
        search(new int[]{3,2},2);
    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0)return -1;
        if(nums.length == 1)return nums[0] == target?0:-1;
        int l = 0, r = nums.length-1;
        while( l <= r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target)return mid;
            if(nums[mid] >= nums[l] && nums[mid] <= nums[r]){
                //全有序
                if(nums[mid] < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else if(nums[mid] >= nums[l]){
                //l-mid有序递增，mid-r无序
                if(nums[l] <= target && target < nums[mid]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }else{
                //0-mid无序，mid-r有序递增
                if(nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }else {
                    r = mid -1;
                }
            }

        }
        return -1;
    }
}