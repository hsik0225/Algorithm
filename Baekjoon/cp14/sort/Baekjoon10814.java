package cp14.sort;

/*

https://www.acmicpc.net/problem/10814

*/

import java.io.*;

public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[10001];
        while (n-- > 0) {
            numbers[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10001; i++) {
            if (numbers[i] > 0) {
                for (int j = 0; j < numbers[i]; j++) {
                    bw.write(Integer.toString(i) + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
