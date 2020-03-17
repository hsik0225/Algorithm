import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int distance = array[1] - array[0];

        for (int i = 2; i < n; i++) {
            distance = gcd(distance, array[i] - array[i - 1]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= distance; i++) {
            if (distance % i == 0) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
