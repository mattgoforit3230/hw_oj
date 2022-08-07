package algorithm.huawei.interview;

import java.util.*;

/**
 * Directory 删除
 * 某文件系统中有 N 个目录，每个目录都一个独一无二的 ID。
 * 每个目录只有一个父目录，但每个父目录下可以有零个或者多个子目录，目录结构呈树状结构。
 * 假设，根目录的 ID 为 0，且根目录没有父目录，其他所有目录的 ID 用唯一的正整数表示，并统一编 号。
 * 现给定目录 ID 和其父目录 ID 的对应父子关系表[子目录 ID，父目录 ID]，以及一个待删除的目录 ID，
 * 请计算并返回一个 ID 序列，表示因为删除指定目录后剩下的所有目录，返回的ID 序列以递增序输出。
 5
 8 6
 10 8
 6 0
 20 8
 2 6
 8
=>2 6
 7
 1 0
 2 1
 3 1
 4 2
 6 3
 5 3
 7 3
 3
 =>1 2 4
 1
 1 0
 1
 =>
 */
public class Interview119H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine().trim());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().trim().split("\\s+");
            int key = Integer.parseInt(split[1]);
            int value = Integer.parseInt(split[0]);
            map.computeIfAbsent(key,k->new ArrayList<Integer>());
            map.get(key).add(value);
        }
        Integer remove = Integer.parseInt(scanner.nextLine().trim());
        if(map.containsKey(remove))map.remove(remove);
        ArrayList<Integer> res = new ArrayList<>();
        dfs(map,res,0,remove);
        res.sort((a,b)->a-b);
        StringBuilder sb = new StringBuilder();
        for(int a:res){
            sb.append(a);
            sb.append(" ");
        }
        if(sb.length() > 0)System.out.println(sb.substring(0,sb.length()-1));
        else System.out.println();
    }

    private static void dfs(HashMap<Integer,
            ArrayList<Integer>> map,ArrayList<Integer> res, int cur,int remove) {
        if(cur != remove && cur != 0)res.add(cur);
        if(!map.containsKey(cur))return;
        for(int temp :map.get(cur)){
            dfs(map,res,temp,remove);
        }


//        List<Integer> parents = new ArrayList<>();
//        List<Integer> nodes = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for (int i = 0; i < num; i++){
//            nodes.add(sc.nextInt());
//            parents.add(sc.nextInt());
//        }
//        int rmId = sc.nextInt();
//
//        Solution s = new Solution();
//        s.buildTree(parents, nodes);
//        s.rmNode(rmId);
//        s.print();
//    }
//}
//class Solution {
//    Map<Integer, List<Integer>> tree = new TreeMap<>();
//    Integer root = -1;
//
//    public void buildTree(List<Integer> parent, List<Integer> node) {
//        for (int i = 0; i < node.size(); i++) {
//            Integer nodeKey = node.get(i);
//            Integer parentKey = parent.get(i);
//            if (!tree.containsKey(nodeKey)) {
//                tree.put(nodeKey, new ArrayList<>());
//            }
//            if (parentKey.equals(0)) {
//                root = nodeKey;
//                continue;
//            }
//            List<Integer> parentList = null;
//            if (tree.containsKey(parentKey)) {
//                parentList = tree.get(parentKey);
//            } else {
//                parentList = new ArrayList<>();
//                tree.put(parentKey, parentList);
//            }
//
//            parentList.add(nodeKey);
//        }
//    }
//    public void rmNode(Integer node) {
//        List<Integer> children = tree.get(node);
//        if (children == null) {
//            return;
//        }
//        if (children.size() == 0) {
//            tree.remove(node);
//            return;
//        }
//
//        for (int i = 0; i < children.size(); i++) {
//            rmNode(children.get(i));
//        }
//        tree.remove(node);
//    }
//    public void print() {
//        Set<Integer> nodes = tree.keySet();
//        tree.keySet().forEach(e -> {
//            System.out.print(e);
//            System.out.print(" ");
//        });
//        System.out.println();
    }
}
