package algorithm.a_leecodeEveryday.a_demo2021_8;

/**
 * 789逃脱阻碍者
 */
public class Demo822 {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,0},{0,3}};
        int[] a = new int[]{0,1};
        escapeGhosts(ints,a);
    }
    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int ghost_dist = 9999;
        int player_dist = target[0] + target[1];
        for (int i = 0; i < ghosts.length; i++) {
            ghost_dist = Math.min(Math.abs(ghosts[i][1]-target[1])+Math.abs(ghosts[i][0]-target[0]),ghost_dist);
        }
        return player_dist<ghost_dist;
    }
}
