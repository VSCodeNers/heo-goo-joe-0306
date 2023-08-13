import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ6603 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] S, lotto;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) { // 무한 루프 돌다가 k -> 0 되면 종료
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            S = new int[k];
            lotto = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            permu(0, 0);
            System.out.println();
        }
    }

    private static void permu(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            lotto[depth] = S[i];
            permu(i + 1, depth + 1);
        }
    }
}

/*
 * 깊이(depth)가 6이 될 때까지 for문 반복함 -> 로또 번호 여섯개니깐
 * depth == 6이 되면 lotto에 담아놓은거 출력
 * 그 다음에 이전 수로 돌아가서 고르지 않았던 번호를 고름
 * ex. [1, 2, 3, 4, 5, 6] -> [1, 2, 3, 4, 5, 7] -> [1, 2, 3, 4, 6, 7] 머 이렇게
 */
