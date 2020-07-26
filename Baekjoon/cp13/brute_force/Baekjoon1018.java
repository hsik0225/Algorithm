package cp13.brute_force;

/*

https://www.acmicpc.net/problem/1018

지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다.

어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.

 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.

구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.

따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.

당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int min = 64;

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        // 하나의 체스판이어도 B 로 시작하거나 W 로 시작할 수 있다
        for (int i = 0; i < 2; i++) {
            int bool = (i == 0 ? 'B' : 'W');

            for (int j = 0; j + 7 < n; j++) {
                for (int k = 0; k + 7 < m; k++) {

                    int paint = 0;
                    for (int l = j; l < j + 8; l++) {
                        for (int o = k; o < k + 8; o++) {
                            if (board[l].charAt(o) == bool)
                                paint++;

                            bool = bool == 'B' ? 'W' : 'B';
                        }

                        bool = bool == 'B' ? 'W' : 'B';
                    }

                    if (paint < min) min = paint;
                }
            }
        }
        System.out.println(min);
    }
}
