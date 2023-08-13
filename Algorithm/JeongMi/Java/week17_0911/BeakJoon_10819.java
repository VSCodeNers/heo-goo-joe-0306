// 백준 - 차이를 최대로(10819)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BeakJoon_10819 {
    static int N;
    static int[] num;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬

        arrSum(0);
        System.out.print(result);
    }
    static void arrSum(int cnt) {
        if(cnt == N) {
            int sum = 0;
            for(int i = 1; i < N; i++) {
                int n = arr[i - 1] - arr[i];
                if(n < 0) n *= -1;
                sum += n;
            }
            result = Math.max(result, sum);

            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[cnt] = num[i];
            arrSum(cnt + 1);
            visited[i] = false;
        }
    }
}