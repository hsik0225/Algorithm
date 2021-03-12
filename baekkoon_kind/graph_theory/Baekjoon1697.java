package graph_theory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697{
    
    private static int n;
    
    private static int m;
    
    private static int[] visited = new int[100_001];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
    
        if (n == m) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }
    
    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
    
            for (int i = 0; i < 3; i++) {
                int next;
                
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                
                if (next == m) {
                    System.out.println(visited[temp]);
                    return;
                }
                
                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}
