package cp6.one_arrays;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/1546

세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.

예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.

세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.

 */
public class Baekjoon1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            max = Math.max(max, score);
            sum += score;
        }

        System.out.println((double) sum/max/n*100);
    }
}
