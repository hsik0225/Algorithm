package cp15.back_tracking;

/*

https://www.acmicpc.net/problem/15651

*/

import java.io.*;

public class Baekjoon15651 {
    private static int n;
    private static int m;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] setting = br.readLine().split(" ");
        n = Integer.parseInt(setting[0]);
        m = Integer.parseInt(setting[1]);

        dfs("", 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(String answer, int depth) throws IOException {
        if (depth >= m) {
            bw.write(answer + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            dfs(answer + i + " ", depth + 1);
        }
    }
}
