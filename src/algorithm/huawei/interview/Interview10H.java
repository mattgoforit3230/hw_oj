package algorithm.huawei.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 比赛
 * 一个有N个选手参加比赛，选手编号为1~N(3<=N<=100)，有M(3<=M<=10)个评委对选手进 行打分。
 * 打分规则为每个评委对选手打分，最高分10分，最低分1分。
 * 请计算得分最多的3位选手的编号。
 * 如果得分相同，则得分高分值最多的选手排名靠前 (10分数量相同，则比较9分的数量，
 * 以此类推，用例中不会出现多个选手得分完全相同的情况)。
 * 4,5
 * 10,6,9,7,6
 *          9,10,6,7,5
 *          8,10,6,5,10
 *          9,10,8,4,9
 */
public class Interview10H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String[] split = first.split(",");
        int M = Integer.parseInt(split[0]),N = Integer.parseInt(split[1]);
        int[][] arr = new int[M][N];
        ArrayList<Player> list = new ArrayList();
        for(int i = 0;i < M;i++){
            String s = scanner.nextLine();
            String[] split1 = s.split(",");
            for(int j = 0;j < N;j++){
                arr[i][j] = Integer.parseInt(split1[j]);
            }
        }
        if(!getScore(arr,list)) System.out.println(-1);
        else {
            list.sort((a,b)->{
                for(int i = 0;i < 12;i++){
                    if(b.scores[i]!=a.scores[i])return b.scores[i]-a.scores[i];
                }
                return -1;
            });
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < N;i++){
                sb.append(list.get(i).num);
                if(i < N-1)sb.append(",");
            }
            System.out.println(sb);
        }
    }
    private static boolean getScore(int[][] arr, ArrayList<Player> list) {
        if(arr.length < 3 || arr.length > 10 || arr[0].length < 3 || arr[0].length > 100)
            return false;
        int M = arr.length,N = arr[0].length;
        for(int i = 0;i < N;i++){
            Player player = new Player(i + 1);
            int sum = 0;
            int[] ints = new int[12];
            //评委个数
            for(int j = 0;j < M;j++){
                if(arr[j][i] > 10 || arr[j][i] < 0)return false;
                sum += arr[j][i];
                ints[11-arr[j][i]]++;
            }
            ints[0] = sum;
            player.scores = ints;
            list.add(player);
        }
        return true;
    }
}
class Player{
    int num;
    int[] scores;
    public Player(int num) {
        this.num = num;
    }
}
