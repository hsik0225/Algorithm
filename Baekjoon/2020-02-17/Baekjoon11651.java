import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon11651 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] location = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] inputLine = br.readLine().split(" ");
            location[i][0] = Integer.parseInt(inputLine[0]);
            location[i][1] = Integer.parseInt(inputLine[1]);
        }

        Arrays.sort(location, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(location[i][0] + " " + location[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
