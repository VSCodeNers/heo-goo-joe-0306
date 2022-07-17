import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = 1;
        int res = 0;

        for (int i = 1; i <= N; i*=10) {
            int end = i * 10 - 1;   //자릿수 끝을 맞춰줌

            if (end > N) end = N;   //end가 N보다 크면 안되므로

            res += (end - i + 1) * len;
            len++;
        }
        System.out.println(res);
    }
}

// 1 ~ 9 = 1자리 / ((9-1+1)*1) -> 9개
// 10 ~ 99 = 2자리 / ((99-10+1)*2) -> 180개
// 100 ~ 999 = 3자리 / ((999-100+1)*3) -> 2700개
