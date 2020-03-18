import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int cloths = Integer.parseInt(br.readLine());

            Map<String, Integer> clothesMap = new HashMap<>();

            for (int j = 0; j < cloths; j++) {
                String type = br.readLine().split(" ")[1];

                if (clothesMap.containsKey(type)) {
                    clothesMap.put(type, clothesMap.get(type) + 1);
                } else {
                    clothesMap.put(type, 1);
                }
            }

            int result = 1;

            for (int count : clothesMap.values()) {
                result *= count + 1;
            }

            bw.write(Integer.toString(result - 1) + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
