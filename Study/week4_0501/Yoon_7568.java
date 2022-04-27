package week4_0501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Yoon_7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int kgcm[][] = new int[N][2];
        int rank;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            kgcm[i][0] = Integer.parseInt(s[0]);
            kgcm[i][1] = Integer.parseInt(s[1]);
        }

        for (int i = 0; i < N; i++) {
            rank = 1;
            
            for (int j = 0; j < N; j++) {
                if (kgcm[i][0] < kgcm[j][0] && kgcm[i][1] < kgcm[j][1])
                    rank++;
            }

            System.out.print(rank + " ");
        }
    }
}
