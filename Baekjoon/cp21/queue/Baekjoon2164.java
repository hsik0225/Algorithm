package cp21.queue;

/*

https://www.acmicpc.net/problem/2164

N장의 카드가 있다.

각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.

우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다.

1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다.

3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.

마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2164 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = 1;

        // 2의 공비이다
        // n = 1, last = 1, 2^0

        // n = 2, last = 2, 2^1

        // n = 3, last = 2
        // n = 4, last = 4, 2^2

        // n = 5, last = 2
        // n = 6, last = 4
        // n = 7, last = 6
        // n = 8, last = 8, 2^3

        // n = 9, last = 2
        // n = 10, last = 4
        // n = 11, last = 6
        // n = 12, last = 8
        // n = 13, last = 10
        // n = 14, last = 12
        // n = 15, last = 14
        // n = 16, last = 16, 2^4

        // while문으로 2^(n-1)을 구한다
        // 즉, n이 몇 번째 군에 속하는지 찾는다
        while (temp < n && (temp*=2) != 0);

        // temp-n으로 n이 temp에서 몇 번째 떨어져 있는지 찾는다
        // 등차수열이므로 떨어져있는 거리 *2를 하여 얼마나 떨어져있는지 계산한다
        // 떨어져있는거리만큼 temp에서 뺀다
        System.out.println(temp - (temp-n)*2);
    }
}
