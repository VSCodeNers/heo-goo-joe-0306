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

//입력받은 수 n을 1,2,3의 합으로 나타내는 방법의 수를 계산하려면
//이전 수의 방법 갯수 + 이이전수의 방법 갯수 + 이이이전수의 방법 갯수 하면됨
//그니까 예를 들어 n이 4라면?
//위의 dp[1], dp[2], dp[3]을 모두 더하면 1+2+4=7이 되니까
//4를 1,2,3의 합으로 나타낼 수 있는 방법의 수는 7이 되는거임
//dp[1]~[3]까지를 적어둔 이유는 dp[N] 계산하려면 i-3까지 계산하는데 i가 0이라면
//오류떠서 i=4부터 하고, dp[3]까지는 그냥 적어둔거임
//나는 재귀로 할까 하다가 그냥 for문씀
