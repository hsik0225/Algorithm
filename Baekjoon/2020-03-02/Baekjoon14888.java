import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] numbers;
    static int[] operators;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        operators = new int[4];

        token(numbers, n);
        token(operators, 4);

        combination(1, numbers[0]);

        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));
    }

    private static void combination(int depth, int sum) {
        if (depth == n) {
            result.add(sum);
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i]!=0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        combination(depth + 1, sum + numbers[depth]);
                        break;
                    case 1:
                        combination(depth + 1, sum - numbers[depth]);
                        break;
                    case 2:
                        combination(depth + 1, sum * numbers[depth]);
                        break;
                    case 3:
                        combination(depth + 1, sum / numbers[depth]);
                        break;
                }
                operators[i]++;
            }
        }
    }

    private static void token(int[] array, int maxIndex) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < maxIndex; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }
}
