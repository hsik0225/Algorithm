import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long two = countZero(a, 2);
        long five = countZero(a, 5);

        two -= countZero(a - b, 2);
        five -= countZero(a - b, 5);

        two -= countZero(b, 2);
        five -= countZero(b, 5);

        System.out.println(Math.min(two, five));
    }

    public static long countZero(long n, long multiple) {
        long count = 0;

        for (long i = multiple; i <= n; i *= multiple) {
            count += n / i;
        }

        return count;
    }
}
