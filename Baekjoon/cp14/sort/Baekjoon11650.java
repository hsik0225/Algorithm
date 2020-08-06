package cp14.sort;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strArray = new String[n];
        while (n-- > 0)
            strArray[n] = br.readLine();

        int[] xArray = new int[strArray.length];
        int[] yArray = new int[strArray.length];
    }
}
