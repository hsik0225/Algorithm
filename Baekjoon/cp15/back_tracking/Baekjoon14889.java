package cp15.back_tracking;

/*

https://www.acmicpc.net/problem/14889

첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14889 {
    static int[][] stats;
    static int min = 200;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        stats = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] statLine = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                stats[i][j] = Integer.parseInt(statLine[j]);
            }
        }
        
        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int current, int depth) {
        if (depth == n/2) {
            int sumStart = 0;
            int sumLink = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j])
                        sumStart += stats[i][j];

                    else if (!visited[i] && !visited[j])
                        sumLink += stats[i][j];
                }
            }

            min = Math.min(min, Math.abs(sumStart - sumLink));
            return;
        }

        for (int i = current; i < n; i++) {
            visited[i] = true;
            dfs(current + 1, depth + 1);
            visited[i] = false;
        }
    }
}
