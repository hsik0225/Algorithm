package cp20.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2667 {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder SB = new StringBuilder();
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(BR.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
    
        // 단지 별 집의 개수를 저장하는 리스트
        List<Integer> houseCounts = new ArrayList<>();
        
        // input 값을 배열에 저장
        for (int i = 1; i <= n; i++) {
            String input = BR.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }
        
        // 깊이 우선 탐색 진행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (checkLocation(i, j)) {
                    
                    // 단지 번호
                    int val = dfs(i, j);
                    houseCounts.add(val);
                }
            }
        }
    
        Collections.sort(houseCounts);
        SB.append(houseCounts.size())
          .append("\n");
        
        for(int num : houseCounts) {
            SB.append(num)
              .append("\n");
        }
    
        System.out.println(SB.toString());
    }
    
    private static int dfs(int x, int y) {
        
        // 단지 별 집의 개수
        int val = 1;
        visited[x][y] = true;
        
        // UP 의 좌표
        if (checkLocation(x - 1, y)) {
            val += dfs(x - 1, y);
        }
        
        // RIGHT 의 좌표
        if (checkLocation(x, y + 1)) {
            val += dfs(x, y + 1);
        }
        
        // DOWN의 좌표
        if (checkLocation(x + 1, y)) {
            val += dfs(x + 1, y);
        }
        
        if (checkLocation(x, y - 1)) {
            val += dfs(x, y - 1);
        }
        
        return val;
    }
    
    private static boolean checkLocation(int x, int y) {
        
        // 좌표값이 잘못된 경우
        if (x < 1 || x > n || y < 1 || y > n) {
            return false;
        }
    
        // 이미 지나간 경로 || 집이 아닌 경우
        return !visited[x][y] && arr[x][y] != 0;
    }
}
