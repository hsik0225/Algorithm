package cp14.dynamic_programming1;

import java.io.*;

public class Baekjoon9184 {

    public static final String BLANK = " ";
    public static final String FORMAT = "w(%d, %d, %d) = %d\n";

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[][][] abc = new int[51][51][51];
    private static final boolean[][][] abcVisited = new boolean[51][51][51];

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] input = BR.readLine().split(BLANK);
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (isEnd(a, b, c)) {
                break;
            }

            BW.write(String.format(FORMAT, a, b, c, recursive(a, b, c)));
        }

        BW.flush();
    }

    private static int recursive(int a, int b, int c) {
        if (anyNegative(a, b, c)) {
            return 1;
        }

        if (abcVisited[a][b][c]) {
            return abc[a][b][c];
        }

        if (anyOver20(a, b, c)) {
            return abc[a][b][c] = recursive(20, 20, 20);
        }

        if (minimumA(a, b, c)) {
            int result = recursive(a, b, c - 1) + recursive(a, b-1, c-1) - recursive(a, b-1, c);
            abcVisited[a][b][c] = true;
            return abc[a][b][c] = result;
        }

        int result = recursive(a-1, b, c) + recursive(a-1, b-1, c) + recursive(a-1, b, c-1) - recursive(a-1, b-1, c-1);
        abcVisited[a][b][c] = true;
        return abc[a][b][c] = result;

    }

    private static boolean anyOver20(int a, int b, int c) {
        return a > 20 || b > 20 || c > 20;
    }

    private static boolean minimumA(int a, int b, int c) {
        return a < b && b < c;
    }

    private static boolean anyNegative(int a, int b, int c) {
        return a <= 0 || b <= 0 || c <= 0;
    }

    private static boolean isEnd(int a, int b, int c) {
        return a == -1 && b == -1 && c == -1;
    }
}
