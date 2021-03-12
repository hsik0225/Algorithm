package cp13.back_tracking;

/*

https://www.acmicpc.net/problem/1759

암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.

또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.

즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.

새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다.

이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.

C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

*/

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1759 {
    private static boolean[] visited;
    private static int[] alphabets;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] setting = scanner.nextLine().split(" ");

        n = Integer.parseInt(setting[0]);

        m = Integer.parseInt(setting[1]);
        String[] inputAlphabets = scanner.nextLine().split(" ");

        // a = 0, z = 25;
        alphabets = new int[m];
        for (int i = 0; i < m; i++) {
            alphabets[i] = inputAlphabets[i].charAt(0) - 97;
        }

        visited = new boolean[m];

        Arrays.sort(alphabets);
        dfs(0, 0, "");

        String s = "asd";
        char c = ((char) (alphabets[0] + 97));
    }

    private static void dfs(int index, int count, String tmp) {
        if (count == n) {
            if (contains(tmp) && tmp.length() == n)
                System.out.println(tmp);

            return;
        }
        for (int i = index; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String test1 = tmp + ((char) (alphabets[i] + 97));
                dfs(i ,count + 1, test1);
                visited[i] = false;
            }
        }
    }

    private static boolean contains(String sb) {
        int mo = 0; int ja = 0;

        for(int i =0 ; i< sb.length();i++){
            if(sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' || sb.charAt(i) == 'u' ){
                mo++;
                continue;
            }
            ja++;
        }
        return mo >= 1 && ja >= 2;
    }
}
