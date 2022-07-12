// 백준 - 날짜 계산(1476)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BeakJoon_1476 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int E, S, M;
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int year = S;
        while(true) {
            if((year - E) % 15 == 0 && (year - M) % 19 == 0) {
                break;
            }
            year += 28;
        }

        System.out.print(year);
    }
}
// year = 15 * ?? + E = 28 * ?? + S = 19 * ?? + M
// year % 15 == E 이런식으로 하면 E가 15일 때 해당이 안 됨.
// (year - E) % 15 == 0 이렇게 해야 모든 경우가 해당됨