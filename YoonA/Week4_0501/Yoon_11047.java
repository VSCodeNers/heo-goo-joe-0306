import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Yoon_11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(s.nextToken());
        int K = Integer.parseInt(s.nextToken());
        int A[] = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N-1; i >= 0; i--) {
            if (A[i] > K)
                continue;
            if (A[i] <= K) {        //K가 크거나 같을 경우는 총 금액 나누기 해당 동전 금액 나눠서 동전 갯수 저장(?)
                count += K / A[i];
            }
        }
        
        System.out.println(count);
    }
}