import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ16198 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int W[];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);
        System.out.println(max);

    }

    public static void DFS(int count, int sum) {
        // 첫번째, 마지막 구슬을 고를 수 없으므로 두 개만 남는 경우 종료
        if (count == N - 2) {
            max = Math.max(max, sum);   // 애너지 최댓값 갱신
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (!check[i]) {
                int left = i - 1;
                int right = i + 1;
                
                // 이미 방문한 에너지 구슬은 빼야하니가
                // 방문하지 않은 구슬을 찾아줌
                while(check[left] && left >= 0) {  
                    left--;
                }
    
                while(check[right] && right < N) {
                    right++;
                }

                check[i] = true;
                DFS(count + 1, sum + (W[left] * W[right]));
                check[i] = false;
            }
        }
    }
}