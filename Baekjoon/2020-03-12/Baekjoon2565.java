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
            pole[i][2] = 1;
        }

        Arrays.sort(pole, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;
                return 0;
            }
        });

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pole[i][1] > pole[j][1]) {
                    pole[i][2] = Math.max(pole[i][2], pole[j][2] + 1);
                }
            }
            max = Math.max(pole[i][2], max);
        }

        System.out.println(n - max);
    }
}
