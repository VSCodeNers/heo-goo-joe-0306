// 백준 - 로또(6603)
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_6603 {
    static int K;
    static int[] num;
    static int[] arr;
    static boolean[] select; // 초기값 false
    static StringBuilder printSet = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break; // 종료 조건

            num = new int[K];
            for(int i = 0; i < K ; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 초기화
            arr = new int[6];
            select = new boolean[K];

            lotto(0, 0);
            printSet.append("\n"); // 테스트 케이스 사이 빈 줄
        }

        System.out.print(printSet);
    }

    static void lotto(int cnt, int start) {
        if(cnt == 6) {
            for(int i = 0; i < 6; i++) {
                printSet.append(arr[i]).append(" ");
            }
            printSet.append("\n");

            return;
        }

        for(int i = start; i < K; i++) {
            if(!select[i]) {
                arr[cnt] = num[i];
                select[i] = true;
                lotto(cnt + 1, i+1);
                select[i] = false;
            }
        }
    }
}