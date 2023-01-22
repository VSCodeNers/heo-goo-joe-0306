import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Yoon_BJ13023 {
    static int N, M;
    static ArrayList<Integer> friends[];
    static boolean check[];
    static boolean status;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            Cal(i, 0);

            if (status) {
                System.out.println(1);      // 5명 이어진 경로가 있다면 1 출력 후, 종료
                return;
            }
        }
        System.out.println(0);
    }

    public static void Cal(int start, int count) {
        if (count >= 4) {
            status = true;
            return;
        }

        for (int i : friends[start]) {
            if (!check[i]) {        
                check[i] = true;
                Cal(i, count + 1);
                check[i] = false;
            }
        }
    }
}
