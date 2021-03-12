package cp1.operation;/*
https://www.acmicpc.net/problem/1008
첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
* */
import java.util.Scanner;

public class Baekjoon1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println((double) a/b);
    }
}
