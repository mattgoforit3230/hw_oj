package algorithm.a_leecodeEveryday.tree;

/**
 * 自上而下 以及 自下而上两种思路
 */
public class Depth {
    int res = 0;
    //自上而下
    public void maximum_depth_top_down(TreeNode node,int depth){
        if(node == null) {
            return;
        }
        if(node.right == null && node.left == null){
            res = Math.max(depth,res);
        }
        maximum_depth_top_down(node.left,depth+1);
        maximum_depth_top_down(node.right,depth+1);
    }

    //自下而上
    public int maximum_depth_bottom_up(TreeNode node){
        if(node == null) {
            return 0;
        }
        int left_depth = maximum_depth_bottom_up(node.left);
        int right_depth = maximum_depth_bottom_up(node.right);
        return Math.max(left_depth,right_depth)+1;
    }

}
