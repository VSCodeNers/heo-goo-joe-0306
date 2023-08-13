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
        if (start == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (check[i] == true)   // 이미 했다면 걍 넘어감
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
 * ex. 예제2는 M이 2니까 한 줄에 두개씩
 * 이미 체크한 수거나 res 그 전 배열이 현재 넣을 수보다 작으면 걍 넘어감
 * ex. 예제2에서 1 7 / 1 8 / 1 9는 7,8,9가 1보다 크니까(res[start-1] < num[i]) 출력
 *              7 1 / 8 7 등은 start-1(7, 8)보다 num[i](1, 7)이 작으니까 출력 XX
 * 밑에 else문 - 우선 check = true로 바꿔놓고 res 배열에 num 배열 값을 넣음
 * 그리고 start 1 증가 시켜줌
 */
