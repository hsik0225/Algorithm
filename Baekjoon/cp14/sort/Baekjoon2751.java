package cp14.sort;

/*

https://www.acmicpc.net/problem/2751

시간복잡도가 O(N logN)인 정렬들
힙 정렬, 합병 정렬

힙 정렬로 풀이
*/

import java.io.*;

public class Baekjoon2751 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        numbers = br.lines().mapToInt(Integer::parseInt).toArray();

        // 힙 정렬은 0 번째 인덱스를 사용하지 않기 때문
        int n = numbers.length - 1;

        // 힙 생성
        for (int i = n/2; i > 0; i--)
            downheap(i, n);

        // 힙 정렬
        while (n > 1) {

            // a[1] 과 힙의 마지막 항목과 교환
            swap(1, n--);

            // 위배된 힙속성 고치기
            downheap(1, n);
        }

        for (int i = 1; i < numbers.length; i++)
            bw.write(numbers[i] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void swap(int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    private static void downheap(int p, int heapSize) {
        while (2 * p <= heapSize) {
            int s = 2 * p;

            // 오른쪽 자식이 큰 경우
            if (s < heapSize && numbers[s] < numbers[s+1])
                s++;

            // 힙 속성을 만족하는 경우
            if (numbers[p] > numbers[s])
                break;

            // 힙속성 만족 안하면 부모(p)와 자식 승자(s) 교환
            swap(p, s);

            // 이제 자식 승자의 자리에 부모가 있게 됨
            p = s;
        }
    }
}
