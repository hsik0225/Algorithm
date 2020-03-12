import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] front = new int[n];
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            front[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    front[i] = Math.max(front[i], front[j] + 1);
                }
            }
        }
        Arrays.sort(front);
        System.out.println(front[n - 1]);
    }
}