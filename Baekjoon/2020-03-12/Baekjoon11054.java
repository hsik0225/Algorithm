import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11054 {
    static int n;
    static int[] front;
    static int[] back;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        front = new int[n];
        back = new int[n];
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            front[i] = back[i] = 1;
        }

        lis();
        reverseLis();

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, front[i] + back[i]);
        }

        System.out.println(max - 1);
    }

    public static void lis() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i] > array[j]) {
                    front[i] = Math.max(front[i], front[j] + 1);
                }
            }
        }
    }

    public static void reverseLis() {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (array[i] > array[j]) {
                    back[i] = Math.max(back[i], back[j] + 1);
                }
            }
        }
    }
}
