package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/1904

피보나추 수열을 이룬다
그 전 단계의 1로 이루어진 수열(ex. 11111)을 제외한 숫자들 앞, 뒤로 1을 추가한다
만약 N이 짝수일 경우
N   가능한 경우
1                                                                   1
2                               00,                                 11
3                           100, 001,                               111
4                    1001, 1100, 0011, 0000,                        1111
5            11001, 10011, 11100, 00111, 10000, 000001,             11111

N - 2 뒤에 00 을 추가
N - 1 앞에 1을 추가
그러면 N이 나온다

나머지에도 분배법칙이 적용되나?
(a + b ) % c = a % c + b % c ?

나머지는 분배법칙이 적용되지 않는다

*/

import java.util.Scanner;

public class Baekjoon1904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fibonacci(scanner.nextInt()));
    }

    private static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 1; i <= n; i++) {
            c = (a + b)%15746;
            a = b;
            b = c;
        }

        return c;
    }
}
