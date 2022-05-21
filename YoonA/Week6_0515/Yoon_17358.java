import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_17358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 음료 갯수
        long cup = 1;    // 컵 경우의 수
        int mod = 1000000007;   // 10^9+7

        for (int i = 1; i < N; i += 2) {   // 블로그 참고 했는데 cup *= i 부분 잘 이해가 안됨 (cup %= mod는 알겠음)
            cup *= i;   
            cup %= mod;
        }
        System.out.println(cup);
    }
}
