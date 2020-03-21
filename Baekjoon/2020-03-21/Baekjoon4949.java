import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;

        for (String input = br.readLine(); !input.equals("."); input = br.readLine()) {
            stack = new Stack<>();

            String answer = "yes";

            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);

                switch (letter) {
                    case '(':
                        stack.push(letter);
                        break;

                    case '[':
                        stack.push(letter);
                        break;

                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            answer = "no";
                        }
                        break;

                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            answer = "no";
                        }
                        break;
                }
            }

            System.out.println(stack.isEmpty() ? answer : "no");
        }
    }
}
