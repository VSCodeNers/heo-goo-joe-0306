import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ10972 {
    private static int N;
    private static int permu[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        permu = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            permu[i] = Integer.parseInt(st.nextToken());
        }

        if (permutation()) {
            for (int i = 0; i < N; i++)
                System.out.print(permu[i] + " ");
        } else
            System.out.println("-1");
    }

    public static boolean permutation() {
        int i = permu.length - 1;
        int j = permu.length - 1;

        while (i > 0 && permu[i - 1] >= permu[i])
            i--; // i보다 작은 수를 찾을 때까지 반복

        if (i == 0)
            return false; // 마지막이면 다음 순열이 없으니까 false

        while (permu[i - 1] >= permu[j]) // i-1번째와 바꿀 다음 큰 수 찾기
            j--;

        swap(i - 1, j); // i-1번째와 j번째 값 자리 교체

        j = permu.length - 1;
        while (i < j)
            swap(i++, j--); // i번째부터 뒤까지 오름차순으로 정렬

        return true;
    }

    public static void swap(int i, int j) {
        int temp = permu[i];
        permu[i] = permu[j];
        permu[j] = temp;
    }
}
