import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//수 정렬하기 2
class Baekjoon2751{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arrayList);

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(arrayList.get(i)) + "\n");
            bw.flush();
        }
    }
}