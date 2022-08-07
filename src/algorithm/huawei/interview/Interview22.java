package algorithm.huawei.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * We Are A Team】
 * 总共有 n 个人在机房，每个人有一个标号(1<=标号<=n)，他们分成了多个团队，
 * 需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的:
 * 1、消息构成为 a b c，整数 a、b 分别代表两个人的标号，整数 c 代表指令
 * 2、c == 0 代表 a 和 b 在一个团队内
 * 3、c == 1 代表需要判定 a 和 b 的关系，如果 a 和 b 是一个团队，输出一行'we are a team',
 * 如果不 是，输出一行'we are not a team'
 * 4、c 为其他值，或当前行 a 或 b 超出 1~n 的范围，输出‘da pian zi'
 * 5 7
 * 1 2 0
 * 4 5 0
 * 2 3 0
 * 1 2 1
 * 2 3 1
 * 4 5 1
 * 1 5 1
 */
public class Interview22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] split = str.split(" ");
        int n = Integer.parseInt(split[0]),m = Integer.parseInt(split[1]);
        if(n < 1 || m < 1 || n >= 100000 || m >= 100000)
            System.out.println("Null");
        else{
            int[] parent = new int[m+1];
            for(int i = 1;i <= m;i++)parent[i] = i;
            for (int i = 0; i < m; i++) {
                String s = scanner.nextLine().trim();
                String[] split1 = s.split(" ");
                int a = Integer.parseInt(split1[0]);
                int b = Integer.parseInt(split1[1]);
                int c = Integer.parseInt(split1[2]);
                if(a < 1 || b < 1 || a > n || b > n || c < 0 || c > 1)
                    System.out.println("da pian zi");
                else{
                    if(c == 0){
                        union(parent,a,b);
                    }else{
                        if(find(parent,a) == find(parent,b))
                            System.out.println("we are a team");
                        else System.out.println("we are not a team");
                    }
                }
            }
        }
    }
    public static int find(int[] parent, int i){
        if(parent[i] != i)parent[i] = find(parent,parent[i]);
        return parent[i];
    }
    public static void union(int[] parent, int x, int y){
        int rootx = find(parent,x);
        int rooty = find(parent,y);
        if(rooty != rootx){
            parent[rootx] = rooty;
        }
    }
}

