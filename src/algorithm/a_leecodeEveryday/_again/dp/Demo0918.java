package algorithm.a_leecodeEveryday._again.dp;
import java.util.*;
public class Demo0918 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aa");
        list.add("a");
        list.add("a");
        Collections.sort(list,(a,b)->{
            if(a.length() != b.length())return b.length()-a.length();
            return a.compareTo(b);
        });
        for (String a:list
             ) {
            System.out.println(a);
        }

    }
    //918. 环形子数组的最大和
    public int maxSubarraySumCircular(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> lsit = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int N = A.length;
        // Compute P[j] = B[0] + B[1] + ... + B[j-1]
        // for fixed array B = A+A
        int[] P = new int[2*N+1];
        for (int i = 0; i < 2*N; ++i)
            P[i+1] = P[i] + A[i % N];
        // Want largest P[j] - P[i] with 1 <= j-i <= N
        // For each j, want smallest P[i] with i >= j-N
        int ans = A[0];
        // deque: i's, increasing by P[i]
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);

        for (int j = 1; j <= 2*N; ++j) {
            // If the smallest i is too small, remove it.
            if (deque.peekFirst() < j-N)
                deque.pollFirst();

            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(j);
        }
        return ans;
    }
}
