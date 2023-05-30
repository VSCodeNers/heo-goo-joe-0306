// 백준 - N과 M 8(15657)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BeakJoon_15657 {
    static int N, M;
    static int[] num;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬
        NandM8(0, "", 0);

        System.out.print(result);
    }
    static void NandM8(int cnt, String sequence, int pre) {
        if(cnt == M) { // 길이가 M인 수열이 만들어진 경우
            result.append(sequence).append("\n");
            return;
        }
        for(int i = pre; i < N; i++) {
            NandM8(cnt + 1, sequence + num[i] + " ", i);
        }
    }
}
