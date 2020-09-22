package cp15.greedy;

/*

https://www.acmicpc.net/problem/1931

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] conference = new int[n][2];

        for (int i = 0; i < n; i++) {
            conference[i][0] = scanner.nextInt();
            conference[i][1] = scanner.nextInt();
        }

        Arrays.sort(conference, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                // 만약 비교하는 값이 같을 경우 시작 시간으로 정렬한다
                if (start[1] == end[1]) {
                    return start[0] - end[0];
                }

                // 그렇지 않다면 종료시간에 따라 정렬한다
                return start[1] - end[1];
            }
        });

        int count = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (conference[i][0] >= end) {
                count++;
                end = conference[i][1];
            }
        }

        System.out.println(count);
    }
}
