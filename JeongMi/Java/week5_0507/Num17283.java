// I am Groot(17283)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num17283 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine());
        int R = Integer.parseInt(bf.readLine());

        int result = 0;
        double R100 = (R * 1.0) / 100.0;
        int n = 2;
        L = (int) (L * R100); //중심 줄기에서 나온 나뭇가지의 길이
        
        while(L > 5) {
            result += L * n;
            n *= 2;
            L = (int) (L * R100);
        }

        System.out.print(result);
    }
}
