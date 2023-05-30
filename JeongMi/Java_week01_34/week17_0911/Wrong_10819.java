// 백준 - 차이를 최대로(10819)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Wrong_10819 {
    static int N;
    static int[] num;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬

        if(N%2 == 0) {
            arr = new int[N];
            for(int i = 0; i < N/2; i++) {
                arr[2*i] = num[N/2 + i];
                arr[2*i + 1]  = num[i];
            }

            System.out.print(arrSum());
        }
        else {
            arr = new int[N];
            for(int i = 0; i < N/2; i++) {
                arr[2*i] = num[N/2 + i];
                arr[2*i + 1]  = num[i];
            }
            arr[N-1] = num[N-1];
            int save1 = arrSum();

            arr = new int[N];
            for(int i = 0; i < N/2; i++) {
                arr[2*i] = num[i];
                arr[2*i + 1]  = num[N/2 + 1 + i];
            }
            arr[N-1] = num[N/2];
            int save2 = arrSum();

            System.out.print((save1 > save2) ? save1 : save2);
        }
    }
    static int arrSum() {
        int sum = 0;
        for(int i = 1; i < N; i++) {
            int n = arr[i - 1] - arr[i];
            if(n < 0) n *= -1;
            sum += n;
        }

        return sum;
    }
}
/*
1 4 8 10 15 20
3 + 4 + 2 + 5 + 5 = 19

10 1 15 4 20 8
9 + 14 + 11 + 16 + 12 = 62

1 4 8 10 15

7 1 10 4 15
6 + 9 + 6 + 11 = 33

1 10 4 15 7
9 + 6 + 11 + 8
*/