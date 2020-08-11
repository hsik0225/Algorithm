package cp14.sort;

/*

https://www.acmicpc.net/problem/10814

온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.

이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.

나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.

입력은 가입한 순서로 주어진다.

첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.

3
21 Junkyu
21 Dohyun
20 Sunyoung
*/

import java.io.*;
import java.util.Arrays;

public class Baekjoon10814 {
    private static String[] answers;
    private static String[] tempStrings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        answers = new String[n];
        tempStrings = new String[n];

        for (int i = 0; i < n; i++) {
            answers[i] = br.readLine();
        }

        mergeSort(0, n - 1);

        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    private static void mergeSort(int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;

        // 앞부분 재귀호출
        mergeSort(low, mid);

        // 뒷부분 재귀호출
        mergeSort(mid + 1, high);

        // 합병
        merge(low, mid, high);
    }

    private static void merge(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {

            // 앞부분이 먼저 소진된 경우
            if (i > mid) {
                tempStrings[k] = answers[j++];
                continue;
            }

            // 뒷부분이 먼저 소진된 경우
            else if (j > high) {
                tempStrings[k] = answers[i++];
                continue;
            }

            int iAge = Integer.parseInt(answers[i].split(" ")[0]);
            int jAge = Integer.parseInt(answers[j].split(" ")[0]);

            if (jAge < iAge)
                tempStrings[k] = answers[j++];

            else
                tempStrings[k] = answers[i++];
        }

        for (int k = low; k <= high; k++) {
            answers[k] = tempStrings[k];
        }
    }
}
