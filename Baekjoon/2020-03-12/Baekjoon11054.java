import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 1;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = 1;
            dp[i][2] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][0] > dp[j][0]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }

                if (dp[i][0] < dp[j][0]) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
//                    dp[i][2] = Math.max(dp[i][2], dp[j][1] + 1);
                }
            }
            max = Math.max(max, Math.max(dp[i][1], dp[i][2]));
        }

        System.out.println(max);
    }
}
