//https://www.acmicpc.net/problem/1149

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] price = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            price[i][0] += Math.min(price[i-1][1], price[i-1][2]);
            price[i][1] += Math.min(price[i-1][0], price[i-1][2]);
            price[i][2] += Math.min(price[i-1][0], price[i-1][1]);
        }

        int min = Math.min(price[n][0], Math.min(price[n][1], price[n][2]));

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
