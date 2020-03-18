import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baekjoon1676 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        BigInteger bigInteger = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        bw.write(remainder10(bigInteger) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static BigInteger remainder10(BigInteger bigInteger) {
        int remaind = bigInteger.remainder(BigInteger.valueOf(10)).intValue();
        if (remaind != 0) {
            return BigInteger.valueOf(count);
        }
        count++;
        return remainder10(bigInteger.divide(BigInteger.valueOf(10)));
    }
}
