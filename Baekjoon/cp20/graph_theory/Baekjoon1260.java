package cp20.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1260 {
    
    private static final String BLANK = " ";
    
    private static int n;
    private static int m;
    private static int v;
    
    private static int[][] map;
    private static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] settings = br.readLine().split(BLANK);
        n = Integer.parseInt(settings[0]);
        m = Integer.parseInt(settings[1]);
        v = Integer.parseInt(settings[2]);
        
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
    
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(BLANK);
            int nodeA = Integer.parseInt(edge[0]);
            int nodeB = Integer.parseInt(edge[1]);
            
            map[nodeA][nodeB] = 1;
            map[nodeB][nodeA] = 1;
        }
        
        dfs(v);
    
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);
    }
    
    private static void dfs(int nodeNumber) {
         visit[nodeNumber] = true;
         
        System.out.print(nodeNumber + BLANK);
    
        for (int j = 1; j <= n; j++) {
            if (map[nodeNumber][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }
    
    private static void bfs(int nodeNumber) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeNumber);
        visit[nodeNumber] = true;
        
        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
    
            System.out.print(visitedNode + BLANK);
    
            for (int i = 1; i <= n; i++) {
                if (map[visitedNode][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
