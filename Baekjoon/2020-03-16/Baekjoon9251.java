//https://www.acmicpc.net/problem/9251

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            char c1 = str1.charAt(i - 1);

            for (int j = 1; j <= length2; j++) {
                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {
                    //값이 같으면 좌측 대각선 위의 값 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //값이 다르다면 좌측(x-1), 상단(y-1)의 값 중 더 큰 값
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[length1][length2]);

        br.close();
    }
}
