//피보나치 수 5(10870)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        System.out.print(fibo(N));
    }
    static int fibo(int N) {
        if(N == 0) return 0;
        if(N == 1 || N == 2) return 1;

        return fibo(N-1) + fibo(N-2);
    }
}
