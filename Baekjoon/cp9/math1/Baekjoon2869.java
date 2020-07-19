package cp9.math1;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/2869

땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

 */
public class Baekjoon2869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int v = scanner.nextInt();

        //c-a까지 간다면 다음 날 낮에 끝까지 올라갈 수 있다.
        //c-a까지 가는 날짜를 구한 후 +1
        //(a-b) 하루동안 올라가는 거리 = 속도
        System.out.println((int) Math.ceil((double) (v-a)/(a-b) + 1));
    }
}
