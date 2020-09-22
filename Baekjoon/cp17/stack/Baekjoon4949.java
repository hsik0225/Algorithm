package cp17.stack;

/*

https://www.acmicpc.net/problem/4949

정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.

문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.

모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.

입력
하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.

입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.

출력
각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 */

import java.io.*;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence;
        Stack<Character> stack;

        while (!(sentence = br.readLine()).equals(".")) {
            boolean balance = true;
            stack = new Stack<>();

            for (char c : sentence.toCharArray()) {
                if (c == '(' || c == '[')
                    stack.push(c);

                else if (c == ')') {
                    if (stack.isEmpty()) {
                        balance = false;
                        break;
                    }

                    if (stack.pop() != '(') {
                        balance = false;
                        break;
                    }
                }

                else if (c == ']') {
                    if (stack.isEmpty()) {
                        balance = false;
                        break;
                    }

                    if (stack.pop() != '[') {
                        balance = false;
                        break;
                    }
                }
            }

            if (balance)
                balance = stack.isEmpty();

            bw.write(balance ? "yes\n" : "no\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
