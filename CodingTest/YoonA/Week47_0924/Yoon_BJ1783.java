import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        // 세로가 1칸인 경우
        // 이동 가능한 칸은 없고 맨 처음 위치 그 한 칸만 방문한 걸로 치니까
        if (N == 1) count = 1;

        // 세로가 2칸인 경우
        // 가로가 5칸 -> count 3 나오고, 가로 7칸 -> count 5.. =>> (가로+1)/2만큼이 count임
        // count가 4를 넘어가면 다른 방법으로도 이동해야 하는데.. 세로 2칸이라 힘드므로 4를 넘어갈 수가 없음.
        if (N == 2) {
            count = (M + 1) / 2;

            if (count > 4) {
                count = 4;
            }
        }

        // 세로가 3칸 이상인 경우
        if (N >= 3) {
            // 1번(2칸 위, 1칸 오), 4번(2칸 아래, 1칸 오)을 반복해보면 1줄 1칸씩..? 이동 가능함
            // 마찬가지로 1, 4만 반복하고 2, 3 방향으론 가지 않기 때문에 count가 4를 넘으면 안됨
            if (M < 7) {
                count = M;

                if (count > 4) {
                    count = 4;
                }
            } 
            // M이 7칸 이상되면 4방향으로 다 갈 수 있음
            else {
                count = M - 2;
            }
        }

        System.out.println(count);
    }
}