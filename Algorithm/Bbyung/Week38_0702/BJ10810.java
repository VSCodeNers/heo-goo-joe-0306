import java.util.Scanner;
import java.util.Arrays;

public class BJ10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int F = sc.nextInt();
            int E = sc.nextInt();
            int ball = sc.nextInt();

            for(int j = F-1; j<E; j++) {
                arr[j] = ball;
            }
        }
        for (int baguni : arr) 
            System.out.print(baguni + " ");
    }
}
