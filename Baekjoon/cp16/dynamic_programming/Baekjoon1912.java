package cp16.dynamic_programming;

/*

https://www.acmicpc.net/problem/1912

풀이
https://zoonvivor.tistory.com/152
*/

import java.util.Scanner;

public class Baekjoon1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = scanner.nextInt();

        for (int i = 1, sum = max; i < n; i++) {
            int number = scanner.nextInt();

            // 여태까지 더한 연속값들이 현재 값보다 크기만 하면 최대값이다
            sum = Math.max(number, sum + number);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
