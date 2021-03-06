package cp6.function;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1065

어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.

등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.

N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Baekjoon1065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 0;

        while (n > 99) {
            if (n/100+n%10 == n-- /10%10*2)
                count++;
        }

        System.out.println(count + n);
    }
}