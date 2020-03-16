import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (j >= i && j < 2 * n - 1 - i) {
                    bw.write("*");
                } else if (j < i) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (j >= i && j < 2 * n - 1 - i) {
                    bw.write("*");
                } else if (j < i) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
