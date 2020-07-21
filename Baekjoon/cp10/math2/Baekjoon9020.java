package cp10.math2;

/*

https://www.acmicpc.net/problem/9020

골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.

이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.

예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.

10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.

만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

 */

import java.util.Scanner;

public class Baekjoon9020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            int x = scanner.nextInt();
            int result = 0;

            for (int i = 2; i <= x/2; i++) {
                if(isPrime(i) && isPrime(x-i)) {
                    result = i;
                }
            }
            System.out.printf("%d %d\n", result, x-result);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
            if (n%i == 0)
                return false;
        }

        return true;
    }
}
