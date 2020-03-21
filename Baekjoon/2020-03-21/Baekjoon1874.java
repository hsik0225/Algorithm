import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        List<Character> answers = new ArrayList<>();
        int[] numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int cursor = 1;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            answers.add('+');
            while (!stack.isEmpty() && stack.peek() == numbers[cursor]) {
                stack.pop();
                answers.add('-');
                cursor++;
            }
        }

        if (stack.isEmpty()) {
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(answers.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}
