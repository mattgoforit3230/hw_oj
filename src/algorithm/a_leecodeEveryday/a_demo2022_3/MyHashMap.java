package algorithm.a_leecodeEveryday.a_demo2022_3;
import java.util.*;
class MyHashMap {
    private static int base = 16;
    private int mod;
    private int hash_value;
    private LinkedList[] arr;
    private Entry<Integer,Integer> entry;
    public MyHashMap() {
        LinkedList<Entry<Integer,Integer>>[] arr = new LinkedList[base];
        for(int i = 0;i < base;i++){
            arr[i] = new LinkedList<Entry<Integer,Integer>>();
        }
    }

    public void put(int key, int value) {
        getMod(key);
        // LinkedList<Entry<Integer,Integer>> list = arr[mod];
        // for(Entry<Integer,Integer> entry: list){
        //     if(entry.getKey() == key){
        //         entry.setValue(value);
        //         return;
        //     }
        // }
        Iterator<Entry> iterator = arr[mod].iterator();
        while(iterator.hasNext()){
            Entry entry = iterator.next();
            if(key == entry.getKey()){
                entry.setValue(value);
                return;
            }
        }
        arr[mod].add(new Entry<Integer,Integer>(key,value));
    }

    public int get(int key) {
        getMod(key);
        LinkedList<Entry<Integer,Integer>> list = arr[mod];
        for(Entry<Integer,Integer> entry: list){
            if(entry.getKey() == key)return entry.getValue();
        }
        return -1;
    }

    public void remove(int key) {
        getMod(key);
        LinkedList<Entry<Integer,Integer>> list = arr[mod];
        for(Entry<Integer,Integer> entry: list){
            if(entry.getKey() == key){
                list.remove(entry);
            }
        }
    }
    private void getMod(int value){
        hash_value = Objects.hash(value);
        //之所以用异或，因为& ｜偏向0或1，异或最均匀
        //为什么要加入高位，因为base一般小于16位，接触不到高位；这样可以让结果更加随机
        mod = (hash_value^hash_value >>>16) & base - 1;
    }
}
class Entry<T,T1>{
    private int key;
    private int value;
    public Entry() {
    }


    public Entry(int key, int value) {
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
