import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int dp[] = new int[11];
        int N;
        
        dp[1] = 1;  //1
        dp[2] = 2;  //1+1, 2
        dp[3] = 4;  //1+1+1, 1+2, 2+1, 3

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
        System.out.println(dp[N]);
        }
    }
}

//arr[i] = arr[i-1]+arr[i-2]+arr[i-3]
