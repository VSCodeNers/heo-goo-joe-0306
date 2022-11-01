// 백준 - 암호 만들기(1759)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BeakJoon_1759 {
    static int L, C;
    static String[] str;
    static String[] arr;
    static boolean[] visited;
    static StringBuilder printSet = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        str = new String[C];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < C; i++) {
            str[i] = st.nextToken();
        }

        Arrays.sort(str); // 사전순 정렬
        arr = new String[L];
        visited = new boolean[C];

        passwords(0, 0);
        System.out.print(printSet);
    }

    // 오름차순으로 정렬된 L개의 문자열 조합 구하기
    static void passwords(int pre, int cnt) {
        if(cnt == L) {
            if(checkCorrect()) { // 최소 한 개의 모음, 최소 2개의 자음인지 확인
                for(int i = 0; i < L; i++) {
                    printSet.append(arr[i]);
                }
                printSet.append("\n");
            }
            return;
        }

        for(int i = pre; i < C; i++) {
            if(!visited[i]) {
                arr[cnt] = str[i];
                visited[i] = true;
                passwords(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }

    // 최소 한 개의 모음, 최소 2개의 자음인지 확인
    static boolean checkCorrect() {
        int mo = 0, ja = 0;

        for(int i = 0; i < L; i++) {
            // 모음 갯수
            if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u"))
                mo++;

            // 자음 갯수
            else ja++;
        }

        if(mo >= 1 && ja >= 2) return true; // 최소 한 개의 모음, 최소 2개의 자음
        return false;
    }
}