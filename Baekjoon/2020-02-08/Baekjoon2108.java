import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


//통계학
public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int maxLength = 0;
        int[] array = new int[8001];

        ArrayList<Integer> inputNumbers = new ArrayList<>();
        ArrayList<Integer> frequencyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int number= Integer.parseInt(br.readLine());
            inputNumbers.add(number);
            sum += number;
            array[number+4000]++;
        }

        Collections.sort(inputNumbers);

        for (int i = 0; i < 8001; i++) {
            if(maxLength<array[i]){
                maxLength = array[i];
                frequencyList.clear();
                frequencyList.add(i-4000);
            }
            else if(maxLength==array[i]){
                frequencyList.add(i-4000);
            }
        }

        System.out.printf("%.0f\n%d\n%d\n%d", (double)sum/inputNumbers.size()
                , inputNumbers.get(inputNumbers.size()/2)
                , frequencyList.size()==1?frequencyList.get(0):frequencyList.get(1)
                , inputNumbers.get(inputNumbers.size()-1)-inputNumbers.get(0));
    }
}
