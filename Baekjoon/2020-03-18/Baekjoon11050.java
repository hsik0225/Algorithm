import java.util.Scanner;

public class Baekjoon11050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = factorial(a) / (factorial(a - b) * factorial(b));

        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

