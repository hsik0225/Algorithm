package cp9.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1978

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
4
1 3 5 7

출력
3

 */
public class Baekjoon1978 {
    private static boolean[] isNotPrime = new boolean[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        isNotPrime[1] = true;

        int count = 0;

        while (n-- > 0) {
            int x = scanner.nextInt();

            // isPrime[1] = 1 , isPrime[2] = 2로 하기 위해서 isPrime.length-1
            int primeLength = (isNotPrime.length - 1);

            if (x > primeLength) {
                isNotPrime = resize(x);
                calculatePrime(x);
            }

            if (!isNotPrime[x]) count++;
        }

        System.out.println(count);
    }

    private static void calculatePrime(int afterCheck) {
        for (int i = 2; i <= afterCheck; i++) {
            for (int j = 2; i * j <= afterCheck; j++) {
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
