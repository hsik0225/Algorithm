import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Baekjoon2580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] sudokuBoard = new int[10][10];
    static List<Point> points = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                sudokuBoard[i][j] = Integer.parseInt(st.nextToken());
                if (sudokuBoard[i][j] == 0) {
                    points.add(new Point(i, j));
                }
            }
        }
        sudoku(0);
    }

    private static void sudoku(int index) {
        if (index == points.size()) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.print(sudokuBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        Point point = points.get(index);

        for (int i = 1; i <= 9; i++) {
            if (isPossible(point.x, point.y, i)) {
                sudokuBoard[point.x][point.y] = i;
                sudoku(index + 1);
                sudokuBoard[point.x][point.y] = 0;
            }
        }
    }

    private static boolean isPossible(int x, int y, int value) {
        for (int i = 1; i <= 9; i++) {
            if (sudokuBoard[x][i] == value) {
                return false;
            }

            if (sudokuBoard[i][y] == value) {
                return false;
            }
        }

        for (int tx = ((x - 1) / 3) * 3 + 1; tx <= ((x - 1) / 3) * 3 + 3; tx++) {
            for (int ty = ((y - 1) / 3) * 3 + 1; ty <= ((y - 1) / 3) * 3 + 3; ty++) {
                if (sudokuBoard[tx][ty] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
