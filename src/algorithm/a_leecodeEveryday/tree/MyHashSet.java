package algorithm.a_leecodeEveryday.tree;
import java.util.*;

//唯一注意的点，要注意hash冲突，还是使用链地址法
public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(2);
//        set.add(5);
        set.remove(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        System.out.println(set.contains(2));
    }
    private static final int base = 1;
    private LinkedList[] arr;
    //哈希值
    private int h;
    //模
    private int mod;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new LinkedList[base];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        mod = mod(key);
        LinkedList<Integer> list = arr[mod];
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){//2
            if (key == iterator.next()){//3

                return;        //add 4
            }
        }
        list.add(key);
    }

    private int mod(int key) {
        int hash = Objects.hash(key);
        //高位运算
        h = hash>>>16 ^ hash;
        //取模
        mod = h & (base-1);
        return mod;
    }

    public void remove(int key) {
        mod = mod(key);
        LinkedList list = arr[mod];
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if (key == iterator.next()){
                //为什么不报错啊？
                //list.remove((Integer)key);
                iterator.remove();
                //return;
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        mod = mod(key);
        LinkedList list = arr[mod];
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

