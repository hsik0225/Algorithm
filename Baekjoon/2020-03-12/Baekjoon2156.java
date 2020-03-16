import java.io.*;

public class Baekjoon2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] front = new int[10001];
        int[] fill = new int[10001];

        for (int i = 1; i <= n; i++) {
            fill[i] = front[i] = Integer.parseInt(br.readLine());
        }

        front[1] = fill[1];

        if (n > 1) {
            front[2] = fill[1] + fill[2];
        }

        for (int i = 3; i <= n; i++) {
            //oox
            int a = front[i - 1];

            //oxo
            int b = front[i - 2] + fill[i];

            //xoo
            int c = front[i - 3] + fill[i - 1] + fill[i];

            //xxoo 를 체크 안해도 되는 이유
            //1 2 3 4 라고 가정했을 때
            //앞에 2개가 xx이므로
            //front[0] = front[1] = front[2]이다
            //그러므로 xoo 와 같다다

            front[i] = Math.max(a, Math.max(b, c));
        }

        System.out.println(front[n]);
    }
}
