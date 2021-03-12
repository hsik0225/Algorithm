package cp9.math2;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1929

M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.


 */
public class Baekjoon1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        boolean[] isNotPrime = new boolean[b+1];
        isNotPrime[1] = true;

        for (int i = 2; i <= b/2; i++) {
            for (int j = 2; i * j <= b; j++) {
                isNotPrime[i * j] = true;
            }
        }

        for (; a <= b; a++) {
            if (!isNotPrime[a])
                System.out.println(a);
        }
    }
}
