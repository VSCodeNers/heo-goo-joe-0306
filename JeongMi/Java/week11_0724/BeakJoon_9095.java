// 백준: 1,2,3 더하기(9095)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BeakJoon_9095 {
    public static void main(String[] args) throws IOException {
        int T, n;
        int[] count = new int[12];

        // 0 -> 0개
        // 1: 1 -> 1개
        // 2: 1+1, 2 -> 2개
        // 3: 1+1+1, 2+1, 1+2, 3 -> 4개
        // 4: 1+1+1+1, 2+1+1, 1+2+1, 3+1, 1+1+2, 2+2, 1+3 -> 7개 = 1+2+4
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수

        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(bf.readLine());
            
            for(int j = 4; j <= n; j++) {
                count[j] = count[j-1] + count[j-2] + count[j-3];
            }
            System.out.println(count[n]);
        }
        bf.close();
    }
}