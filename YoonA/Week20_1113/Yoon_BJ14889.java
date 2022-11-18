import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ14889 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int S[][];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        check = new boolean[N];
    
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Team(0, 0);

        System.out.println(min);
    }

    public static void Team(int start, int count) {
        // 팀이 두개로 나누어지므로 한 팀의 인원수는 N/2임
        if (count == N/2) {
            cal();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                Team(i+1, count+1);
                check[i] = false;
            }
        }
    }

    public static int cal() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                // i, j번째가 true면 스타트팀으로
                if (check[i] == true && check[j] == true) {
                    team_start += S[i][j];
                    team_start += S[j][i];
                }
                // i, j번째가 false면 링크팀으로
                else if (check[i] == false && check[j] == false) {
                    team_link += S[i][j];
                    team_link += S[j][i];
                }
            }
        }

        // 제일 능력치 차이가 적은 것을 반환
        min = Math.min(min, Math.abs(team_start - team_link));
        return min;
    }
}
