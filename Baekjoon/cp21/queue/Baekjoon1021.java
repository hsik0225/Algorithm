package cp21.queue;

/*

https://www.acmicpc.net/problem/1021

문제
지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.)

이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.

N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.

둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.

위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

 */

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열의 크기
        int n = scanner.nextInt();

        // 뽑아내려고 하는 수의 개수
        int m = scanner.nextInt();

        int num;

        int answer = 0;

        boolean flag = false;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        for (int i = 0; i < m; i++, flag = false) {
            num = scanner.nextInt();

            while (!flag) {
                if (deque.get(0) == num) {
                    deque.removeFirst();
                    flag = true;
                }

                else {
                    if (deque.indexOf(num) <= deque.size()/2)
                        deque.addLast(deque.removeFirst());
                    else
                        deque.addFirst(deque.removeLast());
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
