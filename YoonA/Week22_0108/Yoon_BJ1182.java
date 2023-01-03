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
            count--;
            System.out.println(count);
        }
        else {
            System.out.println(count);
        }
    }

    public static void Cal(int start, int sum) {
        if (start == N) {       // N만큼 반복했고,
            if (sum == S) {     // 배열을 더한 값이 S와 같다면
                count++;        // S가 되는 경우의 수가 하나 증가해야 함.
            }
            return;
        }
        Cal(start + 1, sum + suten[start]);     // 현재 sum에 start번째 배열에 든 값을 더함.
        Cal(start + 1, sum);
    }
}
