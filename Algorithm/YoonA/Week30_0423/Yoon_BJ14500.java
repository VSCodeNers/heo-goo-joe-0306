import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ14500 {
    static int N, M;          
    static int max;                   // 합 최댓값
    static int tetromino[][];         // 테트로미노 덩어리들
    static boolean check[][];         // 방문 여부

    // 상하좌우
    static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        check = new boolean[N][M];
        tetromino = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tetromino[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check[i][j] = true;
				DFS(i, j, 1, tetromino[i][j]);
				check[i][j] = false;
                // checkTetro(i, j);
			}
		}

        System.out.println(max);
    }

    public static void DFS(int x, int y, int cnt, int sum) {
        // 테트로미노 하나 당 4개 폴리오미노이므로
        // 4개 모이면 숫자 계산해서 최댓값 구함
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dxx = x + dx[i];
            int dyy = y + dy[i];

            // 범위 밖이면 패스
            if (dxx < 0 || dxx >= N || dyy < 0 || dyy >= M) continue;

            // 방문하지 않았다면? => 방문 여부 체크해주고 탐색 ㄱ
            if(!check[dxx][dyy]) {
				// ㅗ 모양 만들기 위해서는 2번째 칸에서 탐색 한번 더 진행
				if(cnt == 2) {
					check[dxx][dyy] = true;
					DFS(x, y, cnt + 1, sum + tetromino[dxx][dyy]);
					check[dxx][dyy] = false;
				}

				check[dxx][dyy] = true;
                DFS(dxx, dyy, cnt + 1, sum + tetromino[dxx][dyy]);
				check[dxx][dyy] = false;
			}
        }
    }
}
/*

5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5

4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1

 */