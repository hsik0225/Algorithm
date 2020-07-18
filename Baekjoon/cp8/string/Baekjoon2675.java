package cp8.string;

/*

https://www.acmicpc.net/problem/2675

문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.

 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력
2
3 ABC
5 /HTP

출력
AAABBBCCC
/////HHHHHTTTTTPPPPP
 */

import java.util.Scanner;

public class Baekjoon2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.next());

        while (n-- > 0) {
            int loop = Integer.parseInt(scanner.next());
            String word = scanner.next();
            StringBuilder loopWord = new StringBuilder();

            for (char c: word.toCharArray()) {
                loopWord.append(new String(new char[loop]).replace("\0", Character.toString(c)));
            }

            System.out.println(loopWord);
        }
    }
}
