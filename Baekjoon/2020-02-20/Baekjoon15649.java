/*순열 : N개 중에서 R개를 선택
시간복잡도는 O(n!)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon15649 {
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] inputString = br.readLine().split(" ");

        int n = Integer.parseInt(inputString[0]);

        int r = Integer.parseInt(inputString[1]);

        int[] output = new int[r];

        boolean[] visited = new boolean[n+1];

        permutation(output, visited, 0, n, r);
    }

    static void permutation(int[] output, boolean[] visited, int depth, int n, int r) throws IOException {
        if (depth == r) {
            for (int result : output) {
                bw.write(result + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                permutation(output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}
