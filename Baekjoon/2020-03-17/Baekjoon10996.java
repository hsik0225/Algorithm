import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(i % 2 == 0 ? "*" : " ");
        }

        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(i % 2 == 0 ? " " : "*");
        }

        String str = sb.toString();

        for (int i = 1; i < n; i++) {
            sb.append("\n" + str);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
