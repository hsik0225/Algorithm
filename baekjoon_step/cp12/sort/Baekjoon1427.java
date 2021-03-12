package cp12.sort;

/*

https://www.acmicpc.net/problem/1427

*/

import java.util.Scanner;

public class Baekjoon1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(bucketSort(n));
    }

    public static final String bucketSort(int n) {
        StringBuffer sb = new StringBuffer();

        // 숫자의 범위는 0 ~ 9
        // 즉, 10진수임을 의미
        int R = 10;

        // 버킷 생성 및 초기화
        int[] bucket = new int[R];

        // 1단계 : 빈도수 계산
        for (int i = n; i > 0; i /= 10)
            bucket[i % 10]++;

        // 2단계 : 순치적으로 버퍼에 추가
        for (int i = R - 1; i >= 0; i--) {
            while ((bucket[i]--) != 0)
                sb.append(i);
        }

        return sb.toString();
    }
}
