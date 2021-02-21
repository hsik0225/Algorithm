package cp20.graph_theory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1012 {
    
    private static int width;
    
    private static int height;
    
    private static int n;
    
    private static int require = 0;
    
    private static final int[] dx = {0, -1, 0, 1}; // 아래, 위
    
    private static final int[] dy = {1, 0, -1, 0}; // 오른쪽, 왼쪽
    
    private static int[][] cabbageLocation;
    
    private static boolean[][] visited;
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            require = 0;
            width = scanner.nextInt();
            height = scanner.nextInt();
            n = scanner.nextInt();
            
            cabbageLocation = new int[width][height];
            visited = new boolean[width][height];
    
            for (int i = 0; i < n; i++) {
                final int x = scanner.nextInt();
                final int y = scanner.nextInt();
                
                cabbageLocation[x][y] = 1;
            }
            
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (isCabbageThere(i, j)) {
                        bfs(i, j);
                        require++;
                    }
                }
            }
    
            System.out.println(require);
        }
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = true;
            
            for (int i = 0; i < 4; i++) {
                int cabaggeX = point.x + dx[i];
                int cabaggeY = point.y + dy[i];
                
                if (canCabbage(cabaggeX, cabaggeY)) {
                    if (isCabbageThere(cabaggeX, cabaggeY)) {
                        queue.add(new Point(cabaggeX, cabaggeY));
                        visited[cabaggeX][cabaggeY] = true;
                    }
                }
            }
        }
    }
    
    private static boolean canCabbage(int x, int y) {
        return x >= 0 && x  < width && y < height && y >= 0;
    }
    
    private static boolean isCabbageThere(int x, int y) {
        return cabbageLocation[x][y] == 1 && !visited[x][y];
    }
    
    private static class Point {
        int x;
        int y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
