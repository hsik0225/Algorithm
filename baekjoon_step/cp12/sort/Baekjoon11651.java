package cp12.sort;

/*

https://www.acmicpc.net/problem/11651

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11651 {
    private static String[] numbers;
    private static String[] tempNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tempNumbers = new String[n];
        numbers = new String[n];
        for (int i = 0; i < n; i++)
            numbers[i] = br.readLine();

        divide(0, n - 1);

        for (String s : numbers) {
            System.out.println(s);
        }
    }

    private static void divide(int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;

        divide(low, mid);

        divide(mid + 1, high);

        conquer(low, mid, high);
    }

    private static void conquer(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {

            // 만약 왼쪽이 먼저 다 소진되었다면
            if (i > mid) {
                tempNumbers[k] = numbers[j++];
                continue;
            }

            // 만약 오른쪽이 먼저 다 소진되었다면
            else if (j > high) {
                tempNumbers[k] = numbers[i++];
                continue;
            }

            // 양쪽 다 소진되지 않았다면 low 부터 high 까지의 원소들을 각각 하나씩
            // 즉, 왼쪽, 오른쪽으 원소들을 하나씩 비교한다
            String[] leftSplit = numbers[i].split(" ");
            int xLeft = Integer.parseInt(leftSplit[0]);
            int yLeft = Integer.parseInt(leftSplit[1]);

            String[] rightSplit = numbers[j].split(" ");
            int xRight = Integer.parseInt(rightSplit[0]);
            int yRight = Integer.parseInt(rightSplit[1]);

            // 만약 왼쪽 블록 원소의 y가 오른쪽 블록 원소의 y보다 작다면 왼쪽 값이 배열에 들어간다
            if (yLeft < yRight)
                tempNumbers[k] = numbers[i++];

            // 만약 오른쪽 블록 원소의 y가 왼쪽 블록 원소의 y보다 작다면 오른쪽 값이 배열에 들어간다
            else if (yRight < yLeft)
                tempNumbers[k] = numbers[j++];

            // 만약 왼쪽과 오른쪽의 x 원소가 같다면
            else {

                // 만약 왼쪽 블록 원소의 x가 오른쪽 블록 원소의 x보다 작다면 왼쪽 값이 배열에 들어간다
                if (xLeft < xRight)
                    tempNumbers[k] = numbers[i++];

                // 만약 오른쪽 블록 원소의 y가 왼쪽 블록 원소의 y보다 작다면 오른쪽 값이 배열에 들어간다
                else
                    tempNumbers[k] = numbers[j++];
            }
        }

        // low 부터 high 까지 tempNumber 에 대입한 원소들을 기존 배열 numbers 에 복사한다
        for (int l = low; l <= high; l++) {
            numbers[l] = tempNumbers[l];
        }
    }
}
