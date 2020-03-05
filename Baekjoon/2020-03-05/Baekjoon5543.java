//https://www.acmicpc.net/problem/5543

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon5543 {
    static int minBugger = 2001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            minBugger = Math.min(minBugger, Integer.parseInt(br.readLine()));
        }

        int minDrink = Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));

        bw.write(Integer.toString(minDrink + minBugger - 50));
        bw.flush();
        bw.close();
        br.close();
    }
}
