package algorithm.a_leecodeEveryday.a_demo2022_2;

import java.util.HashSet;

public class Solution {
    /**步骤：
     * 1。若key大于节点择取
     * 其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，
     * 然后右子树顶替其位置，由此删除了该节点。
     * 会导致树升高，非平衡二叉树可以这样做
     * @param root
     * @return
     */
    public TreeNode deleteNode(TreeNode root,int key){
        
        if(key > root.val)root.right = deleteNode(root.right,key);
        if(key < root.val)root.left = deleteNode(root.left,key);
        else{

        }
        return root;
    }
}
