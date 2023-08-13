import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_BJ10974 {
    private static int per[];
    private static boolean check[];
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        per = new int[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            per[i] = i + 1; // 1부터 N까지 per에 넣음
        }
        permutation(0);
    }

    public static void permutation(int start) {
        if (start == N) { // start가 N이랑 같아지면 출력
            for (int i = 0; i < N; i++) {
                System.out.print(per[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (check[i] == true) { // 이미 방문했으면 패스함
                    continue;
                } else {
                    check[i] = true;
                    per[start] = i + 1; // 뺑뺑이 돌면서 per 안에 숫자 집어넣음
                    permutation(start + 1); // 다음 자리 per[start+1] 해야되니까
                    check[i] = false;
                }
            }
        }
    }
}
