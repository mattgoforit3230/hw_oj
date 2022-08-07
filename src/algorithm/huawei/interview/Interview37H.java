package algorithm.huawei.interview;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * [37 贪吃蛇]
 *U、D、L、R分别表示贪吃蛇往上、下、左、右和转向，
 * 转向时贪吃蛇不移动 ，G表示贪吃蛇按 当前的方向移动一格。
 L G G U G R G D G G
 3 3
 F F F
 F F H
 E F E

 L G G U G
 3 3
 F F F
 F F H
 E F E
 =>4

 L G G
 3 3
 F F F
 F F H
 E F E
 =>3
 */
public class Interview37H {
    static char[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] order = str.split("\\s+");
        String str2 = scanner.nextLine().trim();
        int n = Integer.parseInt(str2.split("\\s+")[0]),
                m = Integer.parseInt(str2.split("\\s+")[1]);
        matrix = new char[n][m];
        for(int i = 0;i < n;i++){
            String s = scanner.nextLine().trim();
            String[] split = s.split("\\s+");
            for(int j = 0;j < m;j++){
                matrix[i][j] = split[j].charAt(0);
            }
        }
        int[] head = new int[2];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == 'H'){
                    head[0] = i;
                    head[1] = j;
                    break;
                }
            }
        }
        ArrayDeque<int[]> snack = new ArrayDeque<>();
        snack.add(new int[]{head[0],head[1]});
        char pre = 'D';
        for(int i = 0;i < order.length;i++){
            //int y = head[0],x = head[1];
            if(order[i].charAt(0) == 'D'){
                pre = 'D';
                continue;
            }else if(order[i].charAt(0) == 'U'){
                pre = 'U';
                continue;
            }else if(order[i].charAt(0) == 'L'){
                pre = 'L';
                continue;
            }else if(order[i].charAt(0) == 'R'){
                pre = 'R';
                continue;
            }else {
                if(pre == 'D'){
                    head[0]++;
                }else if(pre == 'U'){
                    head[0]--;
                }else if(pre == 'L'){
                    head[1]--;
                }else if(pre == 'R'){
                    head[1]++;
                }
                if(isEnd(snack,head)){
                    System.out.println(snack.size());
                    return;
                }
                if(matrix[head[0]][head[1]] == 'E'){
                    snack.poll();
                }
                snack.add(new int[]{head[0],head[1]});
            }
        }
        System.out.println(snack.size());

    }

    private static boolean isEnd(ArrayDeque<int[]> snack, int[] head) {
        if(head[0] < 0 || head[0] >= matrix.length ||
                head[1] < 0 || head[1] >= matrix[0].length)return true;
        for(int[] body : snack){
            if(head[0] == body[0] && head[1] == body[1])return true;
        }
        return false;
    }
}
