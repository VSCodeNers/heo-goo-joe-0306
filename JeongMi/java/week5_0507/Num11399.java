// ATM(11399)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Num11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] Ptime = new int[N];
        for(int i = 0; i < N; i++) {
            Ptime[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Ptime); //오름차순 정렬

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += Ptime[i] * (N-i);
        }

        System.out.print(sum);
    }
}
