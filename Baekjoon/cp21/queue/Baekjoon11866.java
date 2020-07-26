package cp21.queue;

/*

https://www.acmicpc.net/problem/11866

요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.

한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.

원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= a; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int index = b-1;

        while (true) {
            // (size - index) : 현재 인덱스에서 list size 까지의 거리
            // (b - (size - index )) % size : 인덱스 0에서 몇 번 떨어진 곳에 존재하는가
            sb.append(list.remove(index)).append(", ");
            if (list.isEmpty())
                break;
            index = (b + index - 1)%list.size();
        }

        System.out.println(sb.toString().substring(0, sb.length()-2) + ">");
    }
}
