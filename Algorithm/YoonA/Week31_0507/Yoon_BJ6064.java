import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            // 카잉 달력 마지막 해
            int M = Integer.parseInt(st.nextToken());   
            int N = Integer.parseInt(st.nextToken());
            // 카잉 달력 현재 해
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // <x:y>가 몇 번째 해인지?
            int k = -1;
            for (int j = x; j < N * M; j+=M) {
                // 보니까  출력값 % M(or Y) = x(or y)가 나옴
                if (j % N == y) {       // 이게 맞으면 <x:y>가 j 번째 해라는 의미니까
                    k = j + 1;          // k에 j를 넣음 (아까 -1 했으니까 +1 해서)
                    break;
                } 
            }
            System.out.println(k);
        }
    }
}