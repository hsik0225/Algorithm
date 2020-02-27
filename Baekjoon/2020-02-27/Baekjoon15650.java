/*조합 : N개 중에서 R개를 선택
시간복잡도는 O(n!)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15650 {
    static StringBuilder sb;
    static boolean[] visited;
    static int n;
    static int r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputString = br.readLine().split(" ");

        n = Integer.parseInt(inputString[0]);

        r = Integer.parseInt(inputString[1]);

        visited = new boolean[n+1];

        sb = new StringBuilder();

        combination(1, 0, "");

        System.out.println(sb.toString());
    }

    static void combination(int current, int depth, String str) throws IOException {
        if (depth == r) {
            sb.append(str.trim() + "\n");
            return;
        }

        for (int i = current; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i, depth+1, str + " " + i);
                visited[i] = false;
            }
        }
    }
}
