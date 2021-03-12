package cp9.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/4948

베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤ 123456)

입력의 마지막에는 0이 주어진다.

 */
public class Baekjoon4948 {
    private static boolean[] isNotPrime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        isNotPrime = new boolean[3];
        isNotPrime[1] = true;

        while (true) {
            int count = 0;

            int n = scanner.nextInt();

            if (n == 0)
                break;

            if ((2*n) > isNotPrime.length-1) {
                isNotPrime = resize(2*n);
                calculatePrime(2*n);
            }

            for (int i = n+1; i <= (2*n); i++) {
                if (!isNotPrime[i])
                    count++;
            }

            System.out.println(count);
        }
    }

    private static void calculatePrime(int b) {
        for (int i = 2; i <= b/2; i++) {
            for (int j = 2; i * j <= b; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static boolean[] resize(int size) {
        boolean[] newBooleans = new boolean[size + 1];
        System.arraycopy(isNotPrime, 0, newBooleans, 0, isNotPrime.length);
        return newBooleans;
    }
}
