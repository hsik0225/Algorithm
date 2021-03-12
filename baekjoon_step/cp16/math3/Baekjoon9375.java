package cp16.math3;

/*

https://www.acmicpc.net/problem/9375

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Map<String, Integer> clothes = new HashMap<>();

            int kind = Integer.parseInt(br.readLine());

            for (int j = 0; j < kind; j++) {
                String type = br.readLine().split(" ")[1];

                if (clothes.containsKey(type)) {
                    clothes.put(type, clothes.get(type) + 1);
                } else {
                    clothes.put(type, 1);
                }
            }

            int result = 1;

            /* 각 각 종류를 입지 않는 경우도 존재하므로 + 1 을 해준다
            즉, 옷을 입는 경우의 수는 각 각 종류의 개수 + 1을 서로 곱한 것과 같다
            만약, 모자 2개와 옷 3개가 있을 경우
            가능한 경우의 수 = (모자 2개를 각 각 쓰는 경우 + 모자를 안 쓰는 경우) * (옷 3개를 각 각 입는 경우 + 옷을 안 입는 경우)
            이다
             */
            for (int count : clothes.values()) {
                result *= count + 1;
            }

            // 마지막에 옷을 모두 입지 않은 경우를 제외한다
            System.out.println(result - 1);
        }
    }
}
