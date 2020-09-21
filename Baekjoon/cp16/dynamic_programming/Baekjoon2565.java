package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/2565

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[][] pole = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());

            // pole[i][2]는 설치할 수 있는 전봇대의 개수를 의미한다
            pole[i][2] = 1;
        }

        Arrays.sort(pole, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                return 0;
            }
        });

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // i[1]이 j[1] 보다 클 경우만 전봇대를 설치한다
                if (pole[i][1] > pole[j][1]) {
                    pole[i][2] = Math.max(pole[i][2], pole[j][2] + 1);
                }
            }
            max = Math.max(pole[i][2], max);
        }

        // 전체 전봇대의 개수에서 최디 설치가능한 전봇대의 개수를 뺀다
        System.out.println(n - max);
    }
}
