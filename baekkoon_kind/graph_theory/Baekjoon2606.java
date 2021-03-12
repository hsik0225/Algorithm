package graph_theory;

import java.util.Scanner;

public class Baekjoon2606 {
    private static int[][] graph;
    private static boolean[] visited;
    private static int n;
    private static int m;
    private static int count = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
    
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        dfs(1);
    
        System.out.println(count);
    }
    
    private static void dfs(int i) {
        visited[i] = true;
    
        for (int j = 0; j < n + 1; j++) {
            if (graph[i][j] == 1 && !visited[j]) {
                count++;
                dfs(j);
            }
        }
    }
}
