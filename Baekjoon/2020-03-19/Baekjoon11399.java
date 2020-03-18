import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11399 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time);

        int waitTime = 0;
        int amount = 0;

        for (int i = 0; i < n; i++) {
            waitTime += time[i];
            amount += waitTime;
        }


        System.out.println(amount);
    }
}