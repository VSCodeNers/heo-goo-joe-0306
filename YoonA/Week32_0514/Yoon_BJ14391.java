import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ14391 {
    static int N, M;
    static int max = 0;
    static int paper[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }
        // 탐색 시작
        DFS(0, 0);
        System.out.println(max);
    }

    public static void DFS(int row, int col) {
        // 탐색 끝! / 모두 다 탐색했으면, 이 탐색 때 가로세로 각 합을 구함
        if (row >= N) {
            Cal();
            return;
        }
        // col == M이 되면 한 열을 다 확인했다! 라는 뜻임. true/false 표시 완료 됐다고..
        // 그러면 다음 행 탐색
        if (col >= M) {
            DFS(row + 1, 0);
            return;
        }

        // 가로 숫자에 사용하고 다음 열로 ㄱㄱ  / 가로 -> true
        check[row][col] = true;
        DFS(row, col + 1);

        // 세로 숫자에 포함하고 다음 열로 ㄱㄱ / 세로 -> false
        check[row][col] = false;
        DFS(row, col + 1);
    }

    public static void Cal() {
        int sum = 0;
        
        // 가로 계산
        for (int i = 0; i < N; i++) {
            int plus = 0;
            for (int j = 0; j < M; j++) {
                // 해당 칸이 가로면? 해당 칸 숫자를 plus에 더하고, 
                // true 아니면 세로라는 의미니까 sum에 plus 값 더해주고 plus는 초기화

                // 덧셈할 때, 수의 자리 신경쓰자 (일의 자린지, 십의 자린지)
                if (check[i][j]) {
                    plus *= 10;             // 자릿수 이동 1->10->100.. 4 -> 49 -> 493 이런 식
                    plus += paper[i][j];    // 일의 자리 더하기
                }
                else { 
                    sum += plus;
                }
            }
            sum += plus;
        }
        // 세로 계산
        for (int i = 0; i < M; i++) {
            int plus = 0;
            for (int j = 0; j < N; j++) {
                // 해당 칸이 세로면? 해당 칸 숫자를 plus에 더하고, 
                // false 아니면 가로라는 의미니까 sum에 plus 값 더해주고 plus는 초기화

                // 덧셈할 때, 수의 자리 신경쓰자 (일의 자린지, 십의 자린지)
                if (!check[j][i]) {
                    plus *= 10;     // 자릿수 이동 1->10
                    plus += paper[j][i];
                }
                else {
                    sum += plus;
                }
            }
            sum += plus;
        }
        // 방금 더한 sum이랑 최댓값 max 중에 뭐가 더 큰지. sum이 더 크면 sum -> max
        max = Math.max(max, sum);
    }
}