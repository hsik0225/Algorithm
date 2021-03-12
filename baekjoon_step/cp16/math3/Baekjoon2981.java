package cp16.math3;

/*

https://www.acmicpc.net/problem/2981

주어진 숫자들을 M으로 나누었을 때, 나머지가 모두 같아야 한다.
그렇다면, 어떤 두 수 a = xM + r, b = yM + r을 서로 뺄셈하면
a - b = M(x-y)가 된다.

즉, M은 a - b의 약수가 된다.

이 M은 모든 수들에게 있어야 하는 약수이므로, numbers[i] - numbers[i-1]을 반복문을
돌며 최대공약수를 찾는다.

최대공약수 M으로 나누었을 때, 나머지가 같다면, M의 약수들로 나누었을 때도 나머지가 같다.
그러므로, M의 약수들을 모두 찾은 다음 출력한다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2981 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int subtraction = numbers[1] - numbers[0];
        for (int i = 2; i < n; i++) {
            subtraction = gcd(subtraction, numbers[i] - numbers[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= subtraction; i++) {
            if (subtraction%i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
