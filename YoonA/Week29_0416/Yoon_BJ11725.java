import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Yoon_BJ11725 {
    static int N;
    static int parents[];
    static boolean check[];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        check = new boolean[N+1];
        list = new ArrayList[N+1];

        // ArrayList 초기화 / 안해주면 또 꿍시렁거림
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 이거 왜 해줌? => 서로 연결되어 있으니까
            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);

        // 부모 노드를 2번 노드부터 출력하라고 하였으므로
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void DFS(int now) {
        check[now] = true;

        for (int i = 0; i < list[now].size(); i++) {
            int next = list[now].get(i);
            // 방문하지 않은 노드일 경우? 부모 노드 값 저장하고 자식 노드 탐색
            if (!check[next]) {
                parents[next] = now;
                DFS(next);
            }
        }
    }
}

/* 
1 - 6 - 3 - 5
  - 4 - 2
      - 7
*/
