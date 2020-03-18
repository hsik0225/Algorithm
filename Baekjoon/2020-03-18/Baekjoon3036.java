import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int firstRing = Integer.parseInt(input[0]);

        for (int i = 1; i < n; i++) {
            int gcd = gcd(firstRing, Integer.parseInt(input[i]));

            String denominator = Integer.toString(firstRing / gcd);

            String numerator = Integer.toString(Integer.parseInt(input[i]) / gcd);

            bw.write(denominator + "/" + numerator + "\n");
        }

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
