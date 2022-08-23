import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ15666 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int num[];
    private static int res[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        res = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        NM(0);
        System.out.print(sb);
    }

    public static void NM(int start) {
        if (start == M) {
            for (int i = 0; i < M; i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
        } else {
            int value = 0; // 이전 값을 기억하는 용도
            for (int i = 0; i < N; i++) {
                if (value == num[i]) // for문 돌다가 이전이랑 같은 값 나오면 패스
                    continue;
                if (start != 0 && res[start - 1] > num[i])
                    continue;
                else {
                    res[start] = num[i];
                    NM(start + 1);
                    value = num[i];
                }
            }
        }
    }
}
