import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoon_BJ6118 {
    static int N, M;                        // 헛간 개수, 양 방향 길 개수
    static int barn_num, distance, cnt;     // 헛간 번호, 헛간까지의 거리, 같은 거리 헛간 개수
    static boolean check[];                 // 방문 여부
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barn_num = 0;
        cnt = 0;
        distance = 0;
        check = new boolean[N+1];
        list = new ArrayList[N+1];

        // list 초기화
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());

            list[A_i].add(B_i);
            list[B_i].add(A_i);
        }

        BFS(1);

        System.out.print(barn_num + " " + distance + " " + cnt);
    }

    public static void BFS(int start) {
        Queue<int[]> q = new LinkedList<>();

        // 현재 위치랑 거리 값을 넣어줌
        q.add(new int[]{start, 0});
        check[start] = true;

        while(!q.isEmpty()) {
            int a[] = q.poll();
            int now = a[0];     // 시작점
            int dist = a[1];    // 거리 (재서기가 있는 헛간까지의 거리)

            // 최댓값 찾기
            if (dist > distance) {
                distance = dist;
                barn_num = now;         // 가장 긴 거리를 갖고 있는 점이 시작점됨
                cnt = 1;                // 길이가 같지 않고 무조건 클 때니까 무조건 1
            }
            // 거리가 같으면 그 중 가장 작은 헛간을 출력해야 함. 
            else if (dist == distance) {
                if (barn_num > now) barn_num = now;
                cnt++;      // 그리고 헛간 개수 + 1
            }

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if (!check[next]) {
                    check[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }
    }
}
