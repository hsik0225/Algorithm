import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] people = new String[N];

        for (int i = 0; i < N; i++) {
            people[i] = br.readLine();
        }

        Arrays.sort(people, (o1, o2) -> {
            String firstPersonAge = o1.split(" ")[0];
            String secondPersonAge = o2.split(" ")[0];

            int firstAge = Integer.parseInt(firstPersonAge);
            int secondAge = Integer.parseInt(secondPersonAge);
            return Integer.compare(firstAge, secondAge);
        });

        for (String person : people) {
            bw.write(person + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
