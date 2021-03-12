package graph_theory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2178 {
    private static int n, m;
    private static final int[] DX = {0, 1, 0, -1}; // UP, RIGHT, DOWN, LEFT
    private static final int[] DY = {1, 0, -1, 0};
    private static int[][] maze;
    private static boolean[][] checked;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        maze = new int[n][m];
        checked = new boolean[n][m];
    
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = (int) temp.charAt(j) - 48;
            }
        }
        
        bfs();
        
        System.out.println(maze[n-1][m-1]);
    }
    
    private static void bfs() {
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        
        queueX.offer(0);
        queueY.offer(0);
        
        checked[0][0] = true;
        
        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            
            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int tempX = x + DX[i];
                int tempY = y + DY[i];
                
                // 유효한 범위인지 확인
                if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
                    if(maze[tempX][tempY] == 1 && !checked[tempX][tempY]) {
                        queueX.offer(tempX);
                        queueY.offer(tempY);
                        
                        checked[tempX][tempY] = true;
                        
                        maze[tempX][tempY] = maze[x][y] + 1; // 이동횟수
                    }
                }
            }
        }
    }
}
