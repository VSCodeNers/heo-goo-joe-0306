import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 0;

        for (int i = 1; i <= N; i++) {
        if (i < 10)
            num++;
        else if (i >= 10)
            num += 2;
        }

        System.out.println(num);
    }
}
