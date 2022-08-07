package algorithm.huawei.childrensDay_eve;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

/**
 有一棵二叉树，每个节点由一个大写字母标识（最多二十六个节点），现有两组字母，
 分别表示后序遍历（左孩子-右孩子-父节点）和中序遍历（左孩子-父节点-右孩子）的结果，
 请输出层次遍历的结果
 输入
 输入为两个字符串，分别是二叉树的后序遍历和中序遍历的结果
 输出
 输出层次遍历的结果
 CBEFDA CBAEDF
 ABDCEF
 */
public class Main1{
    static HashMap<Character,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split("\\s+");
        char[] postorder = split[0].toCharArray();
        char[] inorder = split[1].toCharArray();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder.length-1,0,inorder.length-1,postorder,inorder);
        StringBuilder res = new StringBuilder();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode temp = queue.poll();
                res.append(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        System.out.println(res);
    }

    private static TreeNode buildTree(int root_v, int l, int r, char[] postorder, char[] inorder) {
        if(l > r)return null;
        TreeNode root = new TreeNode(postorder[root_v]);
        int int_cur = map.get(postorder[root_v]);
        int right_length = r - int_cur;
        int left_length = int_cur - l;
        root.left = buildTree(root_v-1-right_length,l,int_cur-1,postorder,inorder);
        root.right = buildTree(root_v-1,int_cur+1,r,postorder,inorder);
        return root;
    }
}

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(char val) {
        this.val = val;
    }
}
