/*조합 : N개 중에서 R개를 선택
시간복잡도는 O(n!)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon15652 {
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
            sb.append(str.trim()).append("\n");
            return;
        }

        for (int i = current; i <= n; i++) {
            combination(i, depth+1, str + " " + i);
        }
    }
}

//숏코드
/*import java.util.*;
class Main{
    static int n, m;
    static void func(int cnt, String s, int start) {
        if(cnt == m) {
            System.out.println(s.trim());
            return;
        }
        for(int i=start; i<=n; i++) {
            func(cnt + 1, s + i + " ", i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        func(0, "", 1);
    }
}*/
