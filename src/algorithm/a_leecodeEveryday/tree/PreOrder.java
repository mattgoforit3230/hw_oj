package algorithm.a_leecodeEveryday.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    //根-左-右
    public List<Integer> preOrder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return res;
    }
}
