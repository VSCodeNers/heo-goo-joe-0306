package Week5_0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_17283 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());    // 중심줄기 길이
        int R = Integer.parseInt(br.readLine());    // 비율
        int N = L;
        int total = 0, two = 2;

        while (true) {
            N = (int)(L * (R / 100));
            total += two * N;   // 총 길이 합
            two *= 2; 

            if (N <= 5) {
                System.out.println(total);
                break;
            }
        }

        // for (int two = 2; N > 5; two *= 2) {
        //     N = (int)(L * (R / 100));
        //     total += N * two;
        // }
        // System.out.println(total);
    }
}
