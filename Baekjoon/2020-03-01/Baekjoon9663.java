import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9663 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int firstColumn = 1; firstColumn <= n; firstColumn++) {
            //체스판 N x N개에 Queen 이 들어가야만 count++ 를 하므로
            //첫번째 행에 무조건 Queen 이 들어가야 한다

            //int[] queen 에는 현재줄 row 까지의 queen 이
            //어느 열에 있는지를 넣는다
            int[] queen = new int[n+1];
            queen[1] = firstColumn;
            backTracking(queen, 1);
        }
        System.out.println(count);
    }

    public static void backTracking(int[] queen, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int column = 1; column <= n; column++) {
            queen[row + 1] = column;
            if (isPossible(queen, row+1)) {
                backTracking(queen, row + 1);
            }
        }
    }

    private static boolean isPossible(int[] queen, int row) {
        for (int i = 1; i < row; i++) {
            //같은 열에 있다면 false 를 반환
            if (queen[i] == queen[row]) {
                return false;
            }

            //같은 대각선에 있다면 false 를 반환
            //같은 대각선에 있다는 것은 각도가 45도라는 것을 의미한다
            //대각선의 각도 = 열의 길이 / 행의 길이
            // 행의 길이와 열의 길이가 같다면 45도(tan(1))
            if (Math.abs(i - row) == Math.abs(queen[i] - queen[row])) {
                return false;
            }
        }
        return true;
    }
}
