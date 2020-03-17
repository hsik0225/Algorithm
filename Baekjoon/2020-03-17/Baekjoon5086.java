import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        while (!input[0].equals("0") && !input[1].equals("0")) {
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if (a % b == 0) {
                bw.write("multiple" + "\n");
            } else if (b % a == 0) {
                bw.write("factor" + "\n");
            } else {
                bw.write("neither" + "\n");
            }

            input = br.readLine().split(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
