package algorithm.a_leecodeEveryday.a_demo2022_3;

public class MyTrie {
    int[][] trie;
    int N = 10000;
    int[] count;
    int index;

    public MyTrie() {
        index = 0;
        trie = new int[N][26];
        count = new int[26];
    }

    public void insert(String s){
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if(trie[p][u] == 0)trie[p][u] = ++index;
            p = trie[p][u];
        }
        count[p]++;
    }
    public boolean search(String s){
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if(trie[p][u] == 0)return false;
            p = trie[p][u];
        }
        return count[p] != 0;
    }
    public boolean startsWith(String prefix){
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if(trie[p][u] == 0)return false;
            p = trie[p][u];
        }
        return true;
    }
}
