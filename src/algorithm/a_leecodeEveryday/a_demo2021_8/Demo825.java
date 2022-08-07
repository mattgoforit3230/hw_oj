package algorithm.a_leecodeEveryday.a_demo2021_8;
import java.text.DecimalFormat;
import java.util.*;
/**
 * 797. 所有可能的路径
 */
public class Demo825 {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2},{3},{3},{}};
        //System.out.println(allPathsSourceTarget(ints));
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int a = Integer.parseInt(sc.nextLine());
//            int b = Integer.parseInt(sc.nextLine());
            int a  =234,b=32;
            DecimalFormat df = new DecimalFormat("0.000");
            double dou = (double) b/a*100;

            System.out.println( df.format(dou)+"%");
//        }

    }
    //dfs
//    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        dfs(graph,0,list,res);
//        return res;
//    }
//    private static void dfs(int[][] graph, int start,ArrayList<Integer> list,ArrayList<List<Integer>> res) {
//        //边界
//        if(start == graph.length-1){
//            res.add(new ArrayList<Integer>(list));
//        }
//
//        for (int i = 0; i < graph[start].length; i++) {
//            list.add(graph[start][i]);
//            dfs(graph,graph[start][i],list,res);
//            list.remove(list.size()-1);
//        }
//    }
    //bfs
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        queue.offer(new Node(0));
        while(!queue.isEmpty()){
            //node就是刚取出第节点
            Node node = queue.poll();
            if(node.index == graph.length-1) {
                res.add(new ArrayList<>(node.path));
            }
            int[] ints = graph[node.index];
            for (int index : ints
            ) {

                Node newone = new Node(index,new ArrayList<Integer>(node.path));

                queue.offer(newone);

            }

        }
        return res;
    }
    static class Node{
        int index;
        List<Integer> path;

        public Node(int index, List<Integer> path) {
            this.index = index;
            path.add(index);
            this.path = new ArrayList<>(path);
        }

        public Node(int index) {
            this.index = index;
            this.path = new ArrayList<>();
            path.add(index);
        }
    }
}
