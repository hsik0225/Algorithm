import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon11650 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] array = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] inputLine = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(inputLine[0]);
            array[i][1] = Integer.parseInt(inputLine[1]);
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //x 좌표의 값이 같다면 y 좌표를 기준으로 정렬
                if(o1[0]==o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                //다르다면 x 좌표를 기준으로 정렬
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(array[i][0])
                    + " "
                    + Integer.toString(array[i][1])
                    + "\n");
        }
        bw.flush();
    }
}
