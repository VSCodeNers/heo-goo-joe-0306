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
            int end = i * 10 - 1;

            if (end > N) end = N;

            res += (end - i + 1) * len;
            len++;
        }

        // while (start <= N) {
        //     int end = start * 10 - 1;   //각 자릿수

        //     if (end > N) 
        //         end = N;    //end이 N보다 크면 안되니까 N으로 맞춰줌

        //     res += (end - start + 1) * len;
        //     start *= 10;    //자릿수 계산 끝냈으면 다음 자릿수 계산해야하므로
        //     len += 1;   //자릿수 늘어날수록 길이도 늘어나니까
        // }

        System.out.println(res);
    }
}

// 1 ~ 9 = 1자리 / ((9-1+1)*1) -> 9개
// 10 ~ 99 = 2자리 / ((99-10+1)*2) -> 180개
// 100 ~ 999 = 3자리 / ((999-100+1)*3) -> 2700개
