package algorithm.huawei.interview;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Interview9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splits = s.split("\\s+");
        //首先将数组转为树,再后续遍历非叶节点
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(splits[0]);
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(i < splits.length) {
                node.left = new TreeNode(splits[i++]);
                queue.add(node.left);
            }
            if(i < splits.length) {
                //node.right = new TreeNode(Integer.parseInt(splits[i++]));
                node.right = new TreeNode(splits[i++]);
                queue.add(node.right);
            }
        }
        ArrayDeque<String> res = new ArrayDeque<>();
        dfs(root,res);
        System.out.println(String.join(" ",res));
    }

    private static void dfs(TreeNode root, ArrayDeque<String> res) {
        if(root == null)return;
        dfs(root.left,res);
        dfs(root.right,res);
        if(root.right != null || root.left != null)res.add(root.val);
    }
}
class TreeNode{
    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }
}
/**
 * static class Node {
 *         private int val;
 *         private Node left;
 *         private Node right;
 *         public Node() {
 *         }
 *         public Node(int val) {
 *             this.val = val;
 *         }
 *         public Node(int val, Node left, Node right) {
 *             this.val = val;
 *             this.left = left;
 *             this.right = right;
 *         } }
 *     public static void main(String[] args) {
 *         Scanner in = new Scanner(System.in);
 *         String[] ss = in.nextLine().split(" ");
 *         for (String s : ss) {
 *             queue.add(Integer.parseInt(s));
 *         }
 *         Node root = build();
 *         remove(root);
 *         List<String> p = new ArrayList<>();
 *         print(root, p);
 *         System.out.println(String.join(" ", p));
 *     }
 *     private static Queue<Integer> queue = new ArrayDeque<>();
 *     private static Queue<Node> nodes = new ArrayDeque<>();
 *     public static Node build() {
 *         Node root = new Node(queue.poll());
 *         nodes.add(root);
 *         while (!nodes.isEmpty()) {
 *             Node top = nodes.poll();
 *             if (!queue.isEmpty()) {
 *                 Node left = new Node(queue.poll());
 *                 top.left = left;
 *                 nodes.add(left);
 *             } else {
 *                 break;
 *             }
 *             if (!queue.isEmpty()) {
 *                 Node right = new Node(queue.poll());
 *                 top.right = right;
 *                 nodes.add(right);
 *             } else {
 *                 break;
 *             }
 *         }
 *         return root;
 *     }
 *     public static Node remove(Node root) {
 *         if (root == null) {
 *             return null;
 *         }
 *         if (root.left == null && root.right == null) {
 *             return null;
 *         }
 *         root.left = remove(root.left);
 *         root.right = remove(root.right);
 *         return root;
 *     }
 *     public static void print(Node root, List<String> p) {
 *         if (root == null) {
 *             return;
 *         }
 *         print(root.left, p);
 *         print(root.right, p);
 *         p.add(String.valueOf(root.val));
 *     }
 *
 *
 *
 */
