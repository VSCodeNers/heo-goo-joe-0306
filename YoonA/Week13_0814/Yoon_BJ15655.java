import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ15655 {
    private static int N, M;
    private static int num[];
    private static int res[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        res = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 오름차순 정렬

        NM(0);
    }

    public static void NM(int start) {
        // if (dep == M) {
        // for (int i = 0; i < M; i++) {
        // System.out.print(res[i] + " ");
        // }
        // System.out.println();
        // } else {
        // for (int i = start; i < N; i++) {
        // if (check[i] == true) // 이미 출력한 숫자면 패스
        // continue;
        // else {
        // check[i] = true;
        // res[dep] = num[i];
        // NM(start+1, dep + 1);
        // check[i] = false;

        // }
        // }
        // }
        if (start == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (check[i] == true)
                    continue;
                if (start != 0 && res[start - 1] > num[i])
                    continue;
                else {
                    check[i] = true;
                    res[start] = num[i];
                    NM(start + 1);
                    check[i] = false;
                }
            }
        }
    }
}

/*
 * start == M 은 start가 M이 되면 내려가서 다음 줄에서 출력
 * 밑에 else문 - 우선 check = true로 바꿔놓고 res 배열에 num 배열 값을 넣음
 * 그리고 start 1 증가 시켜줌
 * 
 */
