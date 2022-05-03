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
            if (A[i] <= K) {        
                count += K / A[i];  //총 금액 / i번째 동전 금액 나눠서 동전의 갯수 저장(?) ex) K 5200, A[i] 1000 이면 count = 5
                K %= A[i];      //남은 금액을 K에 다시 저장 ex) K 5200, A[i] 1000 인 경우 200을 다시 K에 저장해서 남은 금액 동전 갯수 구함
            }
        }
        
        System.out.println(count);
    }
}