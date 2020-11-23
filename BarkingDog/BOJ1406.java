import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            leftStack.push(input.charAt(i));
        }

        for (int i = 0, n = Integer.parseInt(br.readLine()); i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (command.startsWith("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (command.startsWith("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (command.startsWith("P")) {
                leftStack.push(command.charAt(2));
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}



