import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ6603 {
    private static int k;
    private static int S[];
    private static int lotto[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;

            S = new int[k];
            lotto = new int[6];
            check = new boolean[k];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            permu(0, 0);
            System.out.println();
        }
    }

    public static void permu(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            lotto[depth] = S[i];
            permu(start + 1, depth + 1);
        }
    }
}
