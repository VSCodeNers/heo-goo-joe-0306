// 동전0(11047)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //동전의 종류
        int K = Integer.parseInt(st.nextToken()); //만들어야 하는 합

        int[] coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        int count = 0;
        for(int i = N-1; i >= 0; i--) {
            count += K / coin[i];
            K %= coin[i];
        }
        System.out.print(count);
    }
}
