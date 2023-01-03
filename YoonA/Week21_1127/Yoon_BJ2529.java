import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Yoon_BJ2529 {
    static ArrayList list = new ArrayList();
    static int k;
    static char[] sign = new char[10];
    static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs(0, " ");
        Collections.sort(list);    

        System.out.println(list.get(list.size() - 1));      // 최대값
        System.out.println(list.get(0));                    // 최소값
    }

    public static void dfs(int count, String num) {
        if (count == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                // 이전 숫자랑 현재 숫자 크기 비교함
                if (count == 0 || check(num.charAt(num.length()-1) - '0', i, sign[count-1])) {
                    visit[i] = true;
                    dfs(count + 1, num + Integer.toString(i));   
                    visit[i] = false;
                }
            }
        }
    }

    public static boolean check(int num1, int num2, char sign) {
        // 부등호가 <이고 num1이 num2보다 작다면 true
        if (sign == '<') {
            if (num1 > num2)
                return false;
        }
        // 부등호가 >이고 num1이 num2보다 크다면 true
        else if (sign == '>') {
            if (num1 < num2)
                return false;
        }
        return true;
    }
}