package algorithm.huawei.interview;

import java.util.*;

/**
 * 数组去重和排序】
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低
 * 进行排序，相同出现次数按照第一次出现顺序进行先后排序。
 */
public class Interview2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        HashMap<String, Node> map = new HashMap<>();
        for(int i = 0;i < split.length;i++){
            if(map.containsKey(split[i])){
                Node node = map.get(split[i]);
                node.num += 1;
                map.put(split[i],node);
            }else{
                Node node = new Node(split[i], i, 1);
                map.put(split[i],node);
            }
        }
        StringBuilder res = new StringBuilder();
        //list
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Node> entry:map.entrySet())list.add(entry.getKey());
        list.sort((a,b)->{
            if(map.get(a).num == map.get(b).num){
                return map.get(a).i -  map.get(b).i;

            }else {
                return map.get(b).num - map.get(a).num;
            }
        });
        for(String str:list)res.append(str);
        System.out.println(String.join(",",res));
    }
}
class Node{
    String val;
    int i;
    int num;
    public Node(String val, int i, int num) {
        this.val = val;
        this.i = i;
        this.num = num;
    }
}
       //数组也可以
//        Node[] nodes = map.values().toArray(new Node[0]);
//        Arrays.sort(nodes,(a,b)->{
//            if(a.num == b.num){
//                return a.i -  b.i;
//            }else {
//                return b.num - a.num;
//            }
//        });
//        for(int i = 0;i < nodes.length;i++){
//            res.append(nodes[i].val);
//            if(i < nodes.length)res.append(",");
//        }
//        System.out.println(res);

