package algorithm.a_leecodeEveryday.tree;
import java.util.*;
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        //map.put(2,1);
        map.remove(2);
        int a =map.get(2);
        System.out.println(a);
    }
    private static final int base = 16;
    private LinkedList[] arr;
    //哈希值
    private int h;
    //模
    private int mod;
    private MyEntry<Integer,Integer> entry;
    /** Initialize your data structure here. */
    public MyHashMap() {

        arr = new LinkedList[base];
        //需要把链表头提前放入数组吗？需要
        for (int i = 0; i < base; i++) {
            arr[i] = new LinkedList<MyEntry<Integer,Integer>>();
        }


    }

    public void put(int key,int value) {
        int hash = Objects.hash(key);
        Integer integer_key = key;
        h = integer_key==null?0:hash^(hash>>>16);
        //取模
        mod = h & (base - 1);
        //如果key相等，则覆盖
        Iterator<MyEntry> iterator = arr[mod].iterator();
        while(iterator.hasNext()){
            MyEntry entry = iterator.next();
            if(key == entry.key){
                iterator.remove();
                return;
            }
        }
        //lambda;将key,value通过entry存入map
        arr[mod].add(new MyEntry<>(key,value));
        //arr[mod].add(new MyEntry<Integer,Integer>(key,value));

    }
    public int get(int key) {
        int hash = Objects.hash(key);
        Integer integer_key = key;
        h = integer_key==null?0:hash^(hash>>>16);
        //取模
        mod = h & (base - 1);
        for (int i = 0; i < arr[mod].size(); i++) {
            MyEntry entry = (MyEntry) arr[mod].get(i);
            if(key == entry.getKey())return entry.getValue();
        }
        return -1;
    }


    public void remove(int key) {
        int hash = Objects.hash(key);
        Integer integer_key = key;
        h = integer_key==null?0:hash^(hash>>>16);
        //取模
        mod = h & (base - 1);
        LinkedList<MyEntry> node = arr[mod];
        for (int i = 0; i < node.size(); i++) {

            if(key == node.get(i).getKey()){
                node.remove(i);
            }
        }
    }

    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//
//    }

    private class MyEntry<T, T1> {
        int key;
        int value;

        public MyEntry() {
        }


        public MyEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

}
