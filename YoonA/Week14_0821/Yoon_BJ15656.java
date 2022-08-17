import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ15656 {
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M;
    private static int num[];
    private static int res[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        res = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        NM(0);

        System.out.println(sb);
    }

    public static void NM(int start) {
        if (start == M) {
            for (int i = 0; i < M; i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                res[start] = num[i];
                NM(start + 1);
            }
        }
    }
}

/*
 * 시간 초과 때문에 System.out.println가 아닌 Stringbilder 사용함
 */