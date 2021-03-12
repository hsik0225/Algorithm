package cp9.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/2581

자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,

이들 소수의 합은 620이고, 최솟값은 61이 된다.

 */
public class Baekjoon2581 {
    private static boolean[] isNotPrime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        isNotPrime = new boolean[b+1];
        isNotPrime[1] = true;

        calculatePrime(b);

        int min = b;
        int result = 0;

        for (; a <= b; a++) {
            if (!isNotPrime[a]) {
                min = Math.min(min, a);
                result += a;
            }
        }

        System.out.println(result == 0 ? -1 : result + "\n" + min);
    }

    private static void calculatePrime(int afterCheck) {
        for (int i = 2; i <= afterCheck; i++) {
            for (int j = 2; i * j <= afterCheck; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }
}
