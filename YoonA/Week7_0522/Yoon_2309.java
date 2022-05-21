import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nanjang = new int[10];
        int sum = 0;
        int nonanjang1 = 0, nonanjang2 = 0;

        for (int i = 0; i < 9; i++) {
            nanjang[i] = Integer.parseInt(br.readLine());
            sum += nanjang[i];
        }

        Arrays.sort(nanjang);

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nanjang[i] + nanjang[j] == sum - 100) {
                    nonanjang1 = nanjang[i];
                    nonanjang2 = nanjang[j];
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (i == nonanjang1 || i == nonanjang2)
                continue;
            System.out.println(nanjang[i]);
        }
    }
}
