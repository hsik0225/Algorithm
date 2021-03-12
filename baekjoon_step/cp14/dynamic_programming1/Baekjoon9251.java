package cp14.dynamic_programming1;

/*

https://www.acmicpc.net/problem/9251

LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

풀이
https://binghedev.tistory.com/12
https://jaesungbong.tistory.com/21
*/

import java.util.Scanner;

public class Baekjoon9251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int lengthA = a.length();
        int lengthB = b.length();

        int[][] dp = new int[lengthA + 1][lengthB + 1];
        for (int i = 1; i <= lengthA; i++) {
            char charA = a.charAt(i-1);

            for (int j = 1; j <= lengthB; j++) {
                char charB = b.charAt(j -1);

                if (charA == charB) {
                    // 값이 같으면 좌측 대각선 위의 값 + 1
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // 값이 다르다면 좌측(x-1), 상단(y-1)의 값 중 더 큰 값
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[lengthA][lengthB]);
    }
}
