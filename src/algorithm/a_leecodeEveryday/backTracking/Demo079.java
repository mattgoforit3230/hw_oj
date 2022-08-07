package algorithm.a_leecodeEveryday.backTracking;
import java.util.*;
public class Demo079 {
    public static void main(String[] args) {
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //"SEEA"
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ESE"));
    }
    //79. 单词搜索
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    public static boolean exist(char[][] board, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (char ch:word.toCharArray()
             ) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(map.containsKey(board[i][j]) && !used[i][j]){
                    boolean flag = dfs(map,board,0,word,i,j,used);
                    if(flag)return flag;
                }
            }
        }
        return false;
    }

    private static boolean dfs(HashMap<Character, Integer> map,char[][] board, int start, String word,int i, int j, boolean[][] used) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length ||  used[i][j] || start == word.length() || board[i][j] != word.charAt(start))return false;

        if(start == word.length()-1 && board[i][j] == word.charAt(start))return true;

        used[i][j] = true;
        for (int k = 0; k < 4; k++) {
            boolean flag = dfs(map,board,start+1,word,i+dx[k],j+dy[k],used);
            if(flag){
                return true;
            }
        }
        used[i][j] = false;
        return false;
    }
}
