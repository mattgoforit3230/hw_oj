package algorithm.huawei.interview;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * 数组二叉树
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，
 * 对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2*N和2*N+1，
 * 并且我们用值-1代表一个节点为空。 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 *
 3 5 7 -1 -1 2 4
 =>3 7 2
 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 =>5 8 7 6
 */
public class Interview89H {
    static int res = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().trim()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedList<String> list = new LinkedList<>();
        dfs(ints, 0);
        while(res >= 0){
            list.addFirst(ints[res]+"");
            res = (res -1 )>>1;
        }
        System.out.println(String.join(" ",list));
    }
    //左子树2*i+1,右2*i+2
    private static void dfs(int[] ints, int i) {
        if(i >= ints.length)return;
        if(isLeaf(ints,i)){
            if(res == -1 || ints[res] > ints[i])res = i;
        }else{
            dfs(ints,2*i+1);
            dfs(ints,2*i+2);
        }
    }
    private static boolean isLeaf(int[] ints, int i){
        if(i >= ints.length)return false;
        int a = 2*i+1,b = 2*i+2;
        if(ints[i] != -1 &&
                (a >= ints.length || ints[a] == -1) &&
                (b >= ints.length || ints[b] == -1))return true;
        return false;
    }
//    private static boolean isLeaf(@NotNull List<Integer> nums, int index) {
//        return (2 * index + 1 >= nums.size() || nums.get(2 * index + 1)== -1)
//                && (2 * index + 2 >= nums.size() || nums.get(2 * index + 2) == -1);
//    }
}
