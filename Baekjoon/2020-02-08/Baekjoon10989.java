import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//카운팅 정렬
class Baekjoon10989{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //숫자는 1만보다 작은 자연수이므로 배열의 크기는 10001개
        int[] array = new int[10001];


        for (int i = 0; i < N; i++) {
            array[Integer.parseInt(br.readLine())] ++;
        }

        for (int i = 1; i < 10000; i++) {
            if(array[i]>0){
                for (int j = 0; j < array[i]; j++) {
                    bw.write(Integer.toString(i) + "\n");
                }
            }
        }
        bw.close();
        br.close();
    }
}