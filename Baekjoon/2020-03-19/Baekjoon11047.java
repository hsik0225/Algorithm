import java.io.*;

public class Baekjoon11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int amount = Integer.parseInt(input[1]);
        int maxIndex = 0;
        int count = 0;

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            if (amount >= value[i]) {
                count += amount / value[i];
                amount %= value[i];
            }
        }

        bw.write(Integer.toString(count));

        bw.flush();
        br.close();
        bw.close();
    }
}