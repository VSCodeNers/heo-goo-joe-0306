import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Yoon_BJ1260 {
    static int N, M, V;
    static boolean res[][];
    static boolean check[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        res = new boolean[N+1][N+1];
        check = new boolean[N+1];

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            res[a][b] = true;
            res[b][a] = true;
        }

        DFS(V);
        Arrays.fill(check, false);          // DFS check 기록 리셋
        System.out.println();      
        BFS(V);
    }

    public static void DFS(int start) {
        check[start] = true;                    // 방문 했다고 표시
        System.out.print(start + " ");          // 수행 결과 하나씩 출력

        for (int i = 0; i < res.length; i++) {
            if (res[start][i] && !check[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        check[start] = true;                    // 방문 했다고 표시
        queue.add(start);

        while(!queue.isEmpty()) {               //  큐가 비어있지 않다면
            start = queue.poll();
            System.out.print(start + " ");      // 수행 결과 하나씩 출력

            for (int i = 0; i < res.length; i++) {
                if (res[start][i] && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
