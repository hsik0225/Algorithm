import java.util.Scanner;

public class Baekjoon10039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;

        for (int i = 0; i < 5; i++) {
            int temp = scanner.nextInt();
            if (temp < 40) {
                temp = 40;
            }
            score += temp / 5;
        }

        System.out.println(score);
    }
}
