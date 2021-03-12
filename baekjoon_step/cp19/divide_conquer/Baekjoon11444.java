package cp19.divide_conquer;

import java.util.HashMap;
import java.util.Scanner;

/*
![image](https://user-images.githubusercontent.com/56301069/110325993-67fdd600-805b-11eb-9c5c-eec436ef7f27.png)

위의 피보나치 성질을 이용하여 구현
 */

public class Baekjoon11444 {
    private static final long MOD = 1_000_000_007L;
    private static HashMap<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        System.out.println(fibo(input));
    }

    private static long fibo(long n) {
        if (n <= 0) {
            return 0;
        }

        else if (n == 1 || n == 2) {
            return 1;
        }

        else if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }

        else {
            long m = (n + 1) / 2;
            long t1;
            long t2;
            if (n % 2 == 1) {
                t1 = fibo(m);
                t2 = fibo(m - 1);
                hashMap.put(n, (t1 * t1 + t2 * t2) % MOD);
            } else {
                t1 = fibo(m - 1);
                t2 = fibo(m);
                hashMap.put(n, ((2 * t1 + t2) * t2) % MOD);
            }
            return hashMap.get(n);
        }
    }
}
