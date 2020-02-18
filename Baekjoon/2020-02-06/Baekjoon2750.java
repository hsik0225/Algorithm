import java.util.Scanner;

//버블 정렬
class Baekjoon2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] array = new int[N];

        for (int index = 0; index < N; index++) {
            array[index] = scanner.nextInt();
        }

        for (int i=0; i<N; i++) {
            for (int M = N-1; M >i; M--) {
                if(array[M]<array[M-1]){
                    int temp = array[M-1];
                    array[M-1] = array[M];
                    array[M] = temp;
                }
            }
            System.out.println(array[i]);
        }
    }
}