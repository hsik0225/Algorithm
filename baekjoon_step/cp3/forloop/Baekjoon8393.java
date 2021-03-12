package cp3.forloop;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/8393

첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

1부터 n까지 합을 출력한다.

 */
public class Baekjoon8393 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println((n*(n+1))/2);
    }
}
