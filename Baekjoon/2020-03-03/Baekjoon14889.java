import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14889 {
    static int n;
    static int[][] statBoard;
    static boolean[] visited;

    static int min = 987654321;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        statBoard = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                statBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);

        System.out.println(min);
    }

    public static void recursive(int depth, int current) {
        if (depth == n / 2) {
            int sum_A = 0;
            int sum_B = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        sum_A += statBoard[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        sum_B += statBoard[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sum_A - sum_B));
            return;
        }

        for (int i = current; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(depth + 1, i);
                visited[i] = false;
            }
        }
    }

}
