package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/9461

첫 삼각형은 정삼각형으로 변의 길이는 1이다.
그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.

P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
*/

import java.util.Scanner;

public class Baekjoon9461 {
    private static long[] sequence = new long[101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            System.out.println(Sequence(scanner.nextInt()));
        }
    }

    private static long Sequence(int n) {
        sequence[1] = 1L;
        sequence[2] = 1L;

        for (int i = 3; i <= n; i++) {
            sequence[i] = sequence[i-2] + sequence[i-3];
        }

        return sequence[n];
    }
}
