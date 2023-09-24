import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int team = Math.min(N / 2, M);  // 인턴 나가는 학생 포함, 만들 수 있는 최대 팀 수

        while(true) {
            // 총 인원에서 팀에 속한 사람들(team * 3)을 제외한 나머지 인원을 구해서
            // 인원이 k보다 크거나 같아야 k 이상이 인턴에 참여 가능
            if (M + N - 3 * team >= K)
                break;
            team -= 1;
        }
        System.out.println(team);
    }
}