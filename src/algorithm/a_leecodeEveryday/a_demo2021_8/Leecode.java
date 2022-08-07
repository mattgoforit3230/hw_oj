package algorithm.a_leecodeEveryday.a_demo2021_8;

import java.util.*;

/**
 * 记录中等难度以上的题目
 */
public class Leecode {
    public static void main(String[] args) {
//        int[] nums =new int[]{1,0,2};
//        for (int a:nums
//             ) {
//            System.out.print(a+" ");
//        }
        int[][] ints = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(searchMatrix(ints,19));


//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]+" , ");
//            }
//            System.out.println();
//        }
    }


    /**
     * 240搜索二维矩阵
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int a=-1;
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] <= target){
                a = i;
            }else{
                break;
            }
        }
        if(a == -1)return false;
        for (int j = a; j >= 0; j--) {
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[i][j] > target)continue;
                if(matrix[i][j] == target)return true;
            }
        }
        return false;
    }

    /**
     * 59螺旋矩阵
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int top = 0,buttom = n -1,left = 0,right = n -1;
        while(cur <= n*n){
            for (int j = left; j < right; j++) {
                res[top][j] = cur;
                cur++;
            }
            for (int j = top; j < buttom; j++) {
                res[j][right] = cur;
                cur++;
            }
            for (int j = right; j > left; j--) {
                res[buttom][j] = cur;
                cur++;
            }
            for (int j = buttom; j >top; j--) {
                res[j][left] = cur;
                cur++;
            }
            top++;
            buttom--;
            left++;
            right--;
            if(top == buttom){
                res[top][top] = cur;
                cur++;
            }
        }
        return res;
    }

    /**
     * 48rotate旋转图像，不借用辅助数组
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j] = temp;
            }
        }
        //对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    /**
     * 56 合并区间(mtd)lambda排序
     * 最开始自己采用用一个动态数组list与给定的intervals挨个比较，list中的cur[],intervals中的obj[],若可以结合则加入list，
     * 大于则删除cur,需要解决的问题一波接一波，比如[1,2][3,4][1,10]当前两个数组进入list中，再被[1,10]取代时候会出现2个[1,10]，
     * 解决办法：[1,10]取代[1,2][3,4]的时候，判断是否覆盖，若全覆盖直接删[1,2][3,4]，出现了新问题，[1,2][3,4]删了空指针了，于是
     * 对list又要加isEmpty判断，干脆分开讨论obj和cur的覆盖问题，留下最后一个问题：若不同add时候，最后一个obj会和list里面所有元素对比，
     * 于是list里面有多少个元素，就会出现多少个obj.....因为obj地址一样，所以list.contains(obj)解决；
     * 但是。。intervals里也有相同obj啊。。。引用地址就不同了
     * 综上，每次补救的时候，没有考虑细致到其他情况，导致一直在填补漏洞
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
//        ArrayList<int[]> list = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int a = i;
//            int[] obj = intervals[i];
//            if(list.isEmpty()){
//                list.add(obj);
//            }else{
//                ArrayList<int[]> temp = new ArrayList<>();
//                temp = (ArrayList<int[]>) list.clone();
//                for (int j = 0;!list.isEmpty() && j < temp.size() ; j++) {
//                    int[] cur = temp.get(j);
//                    //cur包括obj,则不管
//                    if(cur[0] <= obj[0] && cur[1] >= obj[1]){
//                        //obj包括cur,则删除cur,i--;
//                    }else {
//                        if (cur[0] >= obj[0] && cur[1] <= obj[1]) {
//                            int[] remove = list.remove(j);
//                            j--;
//                            i = a - 1;
//                            continue;
//                        } else {
//                            if (cur[0] > obj[1] || cur[1] < obj[0]) {
//                                //合并
//                                if(!list.contains(obj))list.add(obj);
//                            } else {
//                                cur[0] = cur[0] <= obj[0] ? cur[0] : obj[0];
//                                cur[1] = cur[1] >= obj[1] ? cur[1] : obj[1];
//                                //list.add(j, cur);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        int[][] res = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {

            int[] obj = intervals[i];
            if (list.isEmpty()) {
                list.add(obj);
            } else {
                int res[] = list.get(list.size()-1);
                if (obj[0] > list.get(list.size()-1)[1]) {
                    list.add(obj);
                }else{
                    res[1] = res[1]>obj[1]?res[1]:obj[1];

                }
            }
        }
        return list.toArray(new int[list.size()][]);

//        int[][] res = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;

    }

    /**
     * 75颜色分类 荷兰国旗
     */
    public static void sortColors(int[] nums) {
//        int right = nums.length-1;
//        int left = 0;
//        for (int i = 0; i <= right; i++) {
//            while((nums[i] == 2 || nums[i] == 0)&& i >= left && i <= right) {
//                if (nums[i] == 2) {
//                    nums[i] = nums[right];
//                    nums[right] = 2;
//                    right--;
//                }
//                if (nums[i] == 0) {
//                    nums[i] = nums[left];
//                    nums[left] = 0;
//                    left++;
//                }
//            }
//        }
        int right = nums.length-1;
        int left = 0;
        for (int i = 0; i <= right; i++) {
            //问题都出自于这个right，如果只有left直接if就行
            while(i <= right && nums[i] == 2){
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }
            if (nums[i] == 0) {
                    nums[i] = nums[left];
                    nums[left] = 0;
                    left++;
            }
        }
    }

    /**
     * 229求众数，摩尔投票，抵消法
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        //摩尔投票法
        int condi_one = nums[0];
        int count_one = 1;
        int condi_two = nums[0];
        int count_two = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == condi_one || nums[i] == condi_two){
                if(nums[i] == condi_one){
                    count_one++;
                    continue;
                }
                if(nums[i] == condi_two){
                    count_two++;
                    continue;
                }
            }else{

                if(count_one == 0){
                    condi_one = nums[i];
                    count_one = 1;
                    continue;
                }
                if(count_two == 0){
                    condi_two = nums[i];
                    count_two = 1;
                    continue;
                }
                count_one--;
                count_two--;
            }
        }
        count_one=0;
        count_two=0;
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == condi_one)count_one++;
            if(nums[i] == condi_two)count_two++;
        }
        if(condi_one > nums.length/3)list.add(condi_one);
        if(condi_two > nums.length/3)list.add(condi_two);

        return list;
    }

    /**
     *34
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
       int[] res = new int[]{-1,-1};
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                if (flag) {
                    res[1] = i;
                }else{
                    flag = true;
                    res[0] = i;
                    res[1] = i;
                }
            }
        }
        return res;
    }

    /**
     * 15 三数之和
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        List<List<Integer>> res = new ArrayList<>();
        //要排除[-1],[0,0,0]的情况
        if(nums.length<3)return res;
        while(nums[index] <= 0){
            index++;
            if(index == nums.length){
                if(nums[index-1]!=0)return res;
                if(nums[index-2]!=0)return res;
                if(nums[index-3]!=0)return res;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                res.add(list);
                return res;
            }
        }
        //2，从负数集里依次取a，判断正数集里有没有和为-a
        for (int i = 0; i < index; i++) {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0-nums[i];

            int right = nums.length-1;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == nums[j-1] && j!=i+1){
                    continue;
                }
                //两数之和问题

                while(nums[right]+nums[j] > target){
                    right--;
                }
                if(right <= j)break;
                if(nums[right]+nums[j] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[right]);
                    list.add(nums[j]);
                    list.add(nums[i]);
                    if(!res.contains(list))res.add(list);
                }
//                while(nums[right]+nums[j] > target){
//                    right--;
//                }
            }
        }
        return res;
    }

    /**
     * 435无重叠区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //贪心算法
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int obj[] = intervals[i];
            if(list.isEmpty()){
                list.add(obj);
            }else{
                int[] ints = list.get(list.size() - 1);
                if(obj[0] >= ints[1]){
                    list.add(obj);
                }else{
                    if(obj[1] <= ints[1]){
                        list.remove(list.size() - 1);
                        list.add(obj);
                    }
                }
            }

        }
        return intervals.length-list.size();
    }















}
