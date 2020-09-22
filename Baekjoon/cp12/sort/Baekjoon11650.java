package cp12.sort;

/*

https://www.acmicpc.net/problem/11650

2차원 평면 위의 점 N개가 주어진다.

좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

합병 정렬로 풀이
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11650 {
    public static String[] numberStrings;
    public static String[] tempStrings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        numberStrings = new String[n];
        tempStrings = new String[n];
        while (n-- > 0)
            numberStrings[n] = br.readLine();

        mergeSort(0, numberStrings.length - 1);

        for (String s : tempStrings) {
            System.out.println(s);
        }
    }

    private static final void mergeSort(int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;

        // 앞부분 재귀호출
        mergeSort(low, mid);

        // 뒷부분 재귀호출
        mergeSort(mid + 1, high);

        // 합병 수행
        merge(low, mid, high);
    }

    private static void merge(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        String[] iSplit;
        String[] jSplit;

        for (int k = low; k <= high; k++) {

            // 앞부분이 먼저 소진된 경우
            if (i > mid) {
                tempStrings[k] = numberStrings[j++];
                continue;
            }

            // 뒷부분이 먼저 소진된 경우
            else if (j > high) {
                tempStrings[k] = numberStrings[i++];
                continue;
            }

            iSplit = numberStrings[i].split(" ");
            int iX = Integer.parseInt(iSplit[0]);;
            int iY = Integer.parseInt(iSplit[1]);

            jSplit = numberStrings[j].split(" ");
            int jX = Integer.parseInt(jSplit[0]);
            int jY = Integer.parseInt(jSplit[1]);

            // a[j] 가 승자
            if (jX < iX)
                tempStrings[k] = numberStrings[j++];

            else if (jX == iX) {
                if (jY < iY)
                    tempStrings[k] = numberStrings[j++];

                else
                    tempStrings[k] = numberStrings[i++];
            }

            // a[i] 가 승자
            else
                tempStrings[k] = numberStrings[i++];
        }

        // 보조배열 b를 배열 a에 복사
        for (int k = low; k <= high; k++) {
            numberStrings[k] = tempStrings[k];
        }
    }
}
