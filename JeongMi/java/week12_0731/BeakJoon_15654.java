// N과 M(5) - 15654
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BeakJoon_15654 {
    static int[] num;
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder printSet = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬
        NandM(0);
        System.out.print(printSet);
    }
    static void NandM(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                printSet.append(arr[i]).append(" ");
            }
            printSet.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = num[i];
                NandM(cnt + 1);
                visited[i] = false;
            }
        }
    }

}
