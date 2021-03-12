package cp7.string;

import java.util.Scanner;

/*

https://www.acmicpc.net/problem/5622

전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다.

숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.

숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.

상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다.

예를 들어, UNUCIC는 868242와 같다.

할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오

 */
public class Baekjoon5622 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 아스키 코드 A = 65, Z = 90
        // 다이얼 ABC = 2, DEF = 3, ... , WXYZ = 9

        int time = 0;

        for (int letter : scanner.next().toCharArray()) {
            int asc = letter - 65;

            // 만약 문자가 S보다 크다면 1을 빼고, Z라면 1을 더 뺀다
            // 왜냐하면, PQRS, WXYZ는 4개의 문자열을 가지고 있기 때문
            time += (asc - asc / 18 - asc / 25) / 3 + 3;
        }

        System.out.println(time);
    }
}
