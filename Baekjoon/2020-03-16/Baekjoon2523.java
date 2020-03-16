import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Baekjoon2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        for (int i = 1; i <= n; i++) {
            sb.append("*");
            bw.write(sb.toString() + "\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.delete(i - 1, i);
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
    }
}
