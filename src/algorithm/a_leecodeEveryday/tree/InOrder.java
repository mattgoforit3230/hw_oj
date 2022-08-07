package algorithm.a_leecodeEveryday.tree;


import java.util.*;

public class InOrder {



    //左-根-右

    public List<Integer> inorderTraversal(TreeNode root) {
//        char foo='中';
        //Queue<Integer> que = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);



        while(!stack.empty()){
            //首先不断吧左子节点放入，然后拿出来的时候判断有无右子节点，若有则取出再放入右子节点

            //问题，是不是没有左子节点就无法push?
            while(root.left!= null){
                stack.push(root);
                root = root.left;
            }
            root =  stack.pop();
            res.add(root.val);
            if(root.right!=null){
                //两个node
                root = root.right;
            }
        }return res;
//        while(!stack.empty() || root != null){
//            while(root != null){
//                stack.push(root);
//                root = root.leftNode;
//            }
//            if(!stack.empty()){
//                root = stack.pop();
//                root = root.rightNode;
//            }
//        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode();
        //postorder[postorder.length]
        buildTreeDemo(root,inorder,postorder);
        return root;
    }
    //从中序+后序得到树
    public void buildTreeDemo(TreeNode root, int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return;
        }
        int last = postorder[postorder.length-1];
        root.val = last;
        //TreeNode node = new TreeNode(last);
        int index = -1;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == last) index = i;
        }
        int[] new_left_inorder =  Arrays.copyOfRange(inorder,0,index);
        int[] new_left_postorder = Arrays.copyOfRange(postorder,0,index);
        if(new_left_inorder.length != 0 || new_left_postorder.length != 0){
            root.left = new TreeNode();
        }
        int[] new_right_inorder =  Arrays.copyOfRange(inorder,index+1,postorder.length);
        int[] new_right_postorder = Arrays.copyOfRange(postorder,index,postorder.length-1);
        if(new_right_inorder.length != 0 || new_right_postorder.length != 0){
            root.right = new TreeNode();
        }
        //新建一个node,需要提前进行判断
        buildTreeDemo(root.left,new_left_inorder,new_left_postorder);
        buildTreeDemo(root.right,new_right_inorder,new_right_postorder);
    }
    //从中序+前序得到树
    //方法一和<中序+后序得到树>一样，使用递归
    //方法二采用栈,原理：前序数组中，挨着当ab,只能是左节点；若无左节点那就是右节点；若无右节点那就是父类的右节点；

    /**
     * 待解析
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_byStack(int[] preorder, int[] inorder){
        if (preorder.length == 0)
            return null;
        Stack<TreeNode> s = new Stack<>();
        //前序的第一个其实就是根节点
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            //第一种情况
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            } else {
                //第二种情况
                j++;
                //找到合适的cur，然后确定他的右节点
                while (!s.empty() && s.peek().val == inorder[j]) {
                    cur = s.pop();
                    j++;
                }
                //给cur添加右节点
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }

    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;



        return null;
    }


    public static String serialize(TreeNode root) {
        if(root == null)return null;
        //方法一：bps
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<String> list =  new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // int size = queue.size();
            // for(int i = 0;i<size;i++){
            TreeNode node =  queue.poll();
            list.add(String.valueOf(node.val));
            if(node.left == null){
                list.add("#");
            }else{
                queue.offer(node.left);
            }
            if(node.right == null){
                list.add("#");
            }else{
                queue.offer(node.right);
            }
        }
        return String.join(",",list);
        //方法二：dps
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list.poll()));
        queue.offer(root);
        // while(!queue.isEmpty()){
        //     TreeNode node =  queue.poll();
        //      if(!list,isEmpty()){
        //          String val = list.poll();
        //         node.left = new TreeNode();
        //         node.right = new TreeNode();
        //      }
        // }
        while(!list.isEmpty()){
            //String val = list.poll();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String val = list.poll();
                TreeNode node =  queue.poll();
                if("#".equals(val)){
                    node = null;
                }else{
                    node.val = Integer.parseInt(val);
                    queue.offer(node);
                }
            }

        }
        return root;
    }

    /**
     * 渲染图像 dfs深度优先
     * @param
     */
//    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int oldColor = image[sr][sc];
//        dfs(image,sr,sc,oldColor,newColor);
//        return image;
//    }
//    public static void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
//        //出口
//        if(sr < 0|| sr >= image.length || sc < 0 || sc >= image[0].length ||
//                image[sr][sc] != oldColor){return;}
//        image[sr][sc] = newColor;
//        int[] dx ={1,0,0,-1};
//        int[] dy ={0,1,-1,0};
//        for(int i= 0;i < 4 ;i++){
//            dfs(image,sr+dx[i],sc+dy[i],oldColor,newColor);
//        }
//
//    }




    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 2, 3}, {4, 5, 6}
        };
//        int[][] res = floodFill(image, 1, 1, 2);
//        System.out.println(res[0][0]
//        int n = image.length;
//        int m = image[0].length;
//
//        System.out.println(image[0][1]+" , n = "+n+" , m = "+m);
        int temp = 0;
        test(temp);
    }

    private static void test(int temp) {
    }

    /**
     * 广度优先 图像渲染
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int dx[] = {1,0,0,-1};
        int dy[] = {0,1,-1,0};
        int oldColor = image[sr][sc];
        int[] temp = new int[2];
        // bfs需要借助queue实现广度优先,如何在每个节点存sr,sc ==> 用数组
        Queue<int[]> queue = new LinkedList<>();
        if(oldColor != newColor){
            temp[0] = sr;
            temp[1] = sc;
            image[sr][sc] = newColor;
            queue.offer(temp);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i= 0;i < size;i++){
                temp = queue.poll();
                sr = temp[0];sc =temp[1];
                //image[sr][sc] = newColor;
                for(int j = 0;j < 4;j++){
                     int x = sr;
                     int y = sc;
                     x += dx[j];
                     y += dy[j];
//                    sr += dx[j];
//                    sc += dy[j];
                    if(x >= 0 && x < image.length &&
                            y >= 0 && y < image[0].length &&
                            oldColor == image[x][y]){
                        temp[0] = x;
                        temp[1] = y;
                        image[x][y] = newColor;
                        queue.offer(temp);
                    }
                }
            }
        }
        return image;
    }

    /**
     * 小岛最大面积 & 个数
     * @param grid
     * @return
     */

    public int maxAreaOfIsland(int[][] grid) {
        //dfs
        int n = grid.length;
        int m = grid[0].length,res=0,temp=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    temp =  dfs(grid, i, j);
                    res = Math.max(res,temp);
                }
            }
        }
        return res;
    }
//    private int dfs(int[][] grid, int i, int j) {
//        //出口
//        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
//            return 0;
//        }
//        grid[i][j] = 2;
//
//        //temp++;不要这么做，有无返回值搞混淆了，有返回值，理解为：每个dfs为1
//        int temp = 1;
//        //开始上下左右进行扩展
//        int[] dx= {1,0,0,-1},dy={0,-1,1,0};
//        for (int k = 0; k < 4; k++) {
//            i += dx[k];
//            j += dy[k];
//            temp += dfs(grid,i,j);
//        }
//        return temp;
//    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }
}








