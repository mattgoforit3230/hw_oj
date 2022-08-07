package algorithm.a_leecodeEveryday.a_demo2021_9.ramdom;
import java.util.*;

public class Demo0384 {
    int[] ints;
    int[] orig;
    private Random rand = new Random();
    public Demo0384(int[] nums) {
        ints = nums;
        orig = nums.clone();
    }
    public List<Integer> getCopy(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < ints.length;i++){
            list.add(ints[i]);
        }
        return list;
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        ints = orig;
        orig = orig.clone();
        return ints;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> curr = getCopy();
        for(int i = 0;i < ints.length;i++){
            int removeId = rand.nextInt(curr.size());
            ints[i] = curr.get(i);
            curr.remove(i);
        }
        return ints;
    }
}
