import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ15661 {
    static int N, member;
    static int min = Integer.MAX_VALUE;
    static int S[][];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        member = 0;
        S = new int[N][N];
        check = new boolean[N];
    
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 팀별 인원이 정확히 절반이 아닐수도 있으므로
        for(member = 1; member < N; member ++)
            Team(0, 0);

        System.out.println(min);
    }

    public static void Team(int start, int count) {
        // 팀이 두개로 나누어지므로 한 팀의 인원수는 N/2임
        if (count == member) {
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
                if (check[i] == true && check[j] == true) {
                    team_start += S[i][j] + S[j][i];
                }

                else if (check[i] == false && check[j] == false) {
                    team_link += S[i][j] + S[j][i];
                }
            }
        }

        // 스타트, 링크팀의 차이를 구함
        min = Math.min(min, Math.abs(team_start - team_link));
        return min;
    }
}
