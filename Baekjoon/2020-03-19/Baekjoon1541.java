import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] expression = br.readLine().split("[-]");

        int min = 0;

        for (int i = 0; i < expression.length; i++) {
            String[] stringOfValues = expression[i].split("[+]");

            int value = 0;

            for (String stringOfValue : stringOfValues) {
                value += Integer.parseInt(stringOfValue);
            }

            if (i == 0) {
                min += value;
                continue;
            }

            min -= value;

        }

        System.out.println(min);
    }
}
