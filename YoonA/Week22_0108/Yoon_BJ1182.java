import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ1182 {
    static int N, S, count;
    static int suten[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        count = 0;
        suten = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            suten[i] = Integer.parseInt(st.nextToken());
        }
        
        Cal(0, 0);

        if (S == 0) {
            count--;            // S가 0이면 시작 하자마자 count 1 증가하므로
            System.out.println(count);
        }
        else {
            System.out.println(count);
        }
    }

    public static void Cal(int start, int sum) {
        if (start == N) {       // N만큼 반복했다면 리턴
            if (sum == S) {     // 더한 값과 S가 같다면
                count++;        // S가 되는 경우의 수가 하나 증가해야 함
            }
            return;
        }

        // 잘 몰라서 찾아봄.
        // 현재 suten[start] 값도 더한 경우, 더하지 않은 경우
        // 이 두 가지로 나누어 탐색한다고 함
        Cal(start + 1, sum + suten[start]);
        Cal(start + 1, sum);
    }
}
