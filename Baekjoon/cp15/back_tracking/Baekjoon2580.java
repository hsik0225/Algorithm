package cp15.back_tracking;

/*

https://www.acmicpc.net/problem/2580

스도쿠

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다.

스도쿠 판의 빈 칸의 경우에는 0이 주어진다.

스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
*/

import java.util.Scanner;

public class Baekjoon2580 {
    private static int[][] map = new int[9][9];
    private static boolean[][] checkX = new boolean[9][10];
    private static boolean[][] checkY = new boolean[9][10];
    private static boolean[][] check = new boolean[9][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] != 0) {

                    // i 번째 줄의 숫자들 중 1 ~ 9 까지 나온 숫자들을 true 로 변경한다
                    checkX[i][map[i][j]] = checkY[j][map[i][j]] = check[3 * (i / 3) + j / 3][map[i][j]] = true;
                }
            }
        }

        sudoku(0, 0);
    }

    private static boolean sudoku(int x, int y) {
        if (y == 9) {
            y = 0;
            x++;
        }

        if (x == 9) {
            print();
            return true;
        }

        if (map[x][y] != 0)
            return sudoku(x, y + 1);

        for (int i = 1; i <= 9; i++) {
            if (checkX[x][i] || checkY[y][i] || check[3 * ( x / 3) + y / 3][i])
                continue;
            map[x][y] = i;
            checkX[x][i] = checkY[y][i] = check[3 * ( x / 3) + y / 3][i] = true;
            if (sudoku(x, y + 1))
                return true;
            map[x][y] = 0;
            checkX[x][i] = checkY[y][i] = check[3 * ( x / 3) + y / 3][i] = false;
        }

        return false;
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
