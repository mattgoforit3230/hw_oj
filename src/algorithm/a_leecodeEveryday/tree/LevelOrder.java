package algorithm.a_leecodeEveryday.tree;
import java.util.*;

/**
 * 借助一个队列
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        que.offer(root);
        //边界怎么找
        while(!que.isEmpty()){
            TreeNode node =  que.poll();
            //LinkedList<Integer> temp = new LinkedList<>();
            temp.add(node.val);
            if(que.isEmpty()){
                if(node.left != null){
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
                res.add(temp);
                temp = new LinkedList<>();
            }
            // if(node.left != null){
            //     que.offer(node.left);
            // }
            // if(node.right != null){
            //     que.offer(node.right);
            // }
            // res.add(temp);
            // temp.clear();
        }
        return res;
    }
}
