import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ10819 {
    private static int N, max;
    private static int A[];
    private static int Arr[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        Arr = new int[N];
        check = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(max);
    }

    public static void permutation(int start) {
        int sum = 0;

        if (start == N) {
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(Arr[i] - Arr[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i] == true)
                continue;
            else {
                check[i] = true;
                Arr[start] = A[i];
                permutation(start + 1);
                check[i] = false;
            }
        }
    }
}

/*
 * permutation()은 일단 순열?로 풀었길래 아래 for문은 예전에 해놨던 코드 적었고
 * start == M 부분은
 * Arr 다 채웠으면 이 배열을 식대로 계산해서 sum에 넣고
 * sum이랑 최댓값(max) 비교해서 더 큰 걸 max에 넣음
 */