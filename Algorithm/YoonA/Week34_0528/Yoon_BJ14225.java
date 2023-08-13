import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ14225 {
    static int N;
    static int S[];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        // 이거.. 배열 크기.. 합으로 나올 수 있는 최댓값이 이거라서 이래 함..
        // 안 하니까 오류나던데
        S = new int[100000 * 20 + 1];
        check = new boolean[100000 * 20 + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        for (int i = 1; i < S.length; i++) {
            // 방문한 적 없으면 합으로 안 나왔다는 뜻이니까 출력
            if (!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void DFS(int count, int sum) {
        // 값 구했으면 그그.. 더한 값 체크..
        if (count == N) {
            check[sum] = true;
            return;
        }
        // 탐색 ㄱ
        // 현재 숫자에 다음 숫자 더한 경우, 아닌 경우 둘 다 탐색
        DFS(count + 1, sum + S[count]);
        DFS(count + 1, sum);
    }
}
