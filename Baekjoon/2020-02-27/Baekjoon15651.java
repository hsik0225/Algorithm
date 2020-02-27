/*조합 : N개 중에서 R개를 선택
시간복잡도는 O(n!)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15651 {
    static StringBuilder sb;
    static int n;
    static int r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputString = br.readLine().split(" ");

        n = Integer.parseInt(inputString[0]);

        r = Integer.parseInt(inputString[1]);

        sb = new StringBuilder();

        combination(1, 0, "");

        System.out.println(sb.toString());
    }

    static void combination(int current, int depth, String str) throws IOException {
        if (depth == r) {
            sb.append(str.trim() + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            combination(i, depth+1, str + " " + i);
        }
    }
}
