package cp12.sort;

/*

https://www.acmicpc.net/problem/2108

수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

힙 정렬로 풀이

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int [n + 1];

        // 입력이 음수도 존재한다
        // 입력값은 절대값으로 4000이 넘지 않으므로 + 4000을 해주면 모든 값은 양수로 계산할 수 있다
        int[] counts = new int [8001];
        int[] temp = new int[8001];

        int sum = 0;

        for (int i = 1; i < n + 1; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
            sum += number;
            counts[number + 4000]++;
            temp[number + 4000]++;
        }

        sort(numbers);
        sort(temp);

        int maxCount = temp[8000];
        int max = 0;
        int first = 0;

        for (int i = 0, second = 0; i < 8001 && second < 2; i++) {
            if (counts[i] == maxCount) {
                if (first == 0) {
                    max = i;
                    first = i;
                }
                if ((second = second + 1) == 2)
                    max = i;
            }
        }

        System.out.printf("%.0f\n%d\n%d\n%d",
                (double) sum / n
                , numbers[n/2 + 1]
                , max - 4000
                , numbers[n] - numbers[1]);
    }

    private static void sort(int[] array) {
        int heapSize = array.length - 1;

        // 힙 생성
        for (int i = heapSize / 2; i > 0; i--)
            downheap(array, i, heapSize);

        // 힙 정렬
        while (heapSize > 1) {
            swap(array, 1, heapSize--);
            downheap(array, 1, heapSize);
        }
    }

    private static void downheap(int[] array, int p, int heapSize) {
        while (2 * p <= heapSize) {
            int s = 2 * p;

            if (s < heapSize && array[s] < array[s+1])
                s++;

            if (array[p] > array[s])
                break;

            swap(array, p, s);

            p = s;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
