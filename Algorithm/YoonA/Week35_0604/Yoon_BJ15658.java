import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_BJ15658 {
    static int N;
    static int A[];
    static int oper[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        oper = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oper.length; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int count, int sum) {
        if (count == N) {
            // sum이랑 현재 최대, 최소값 비교해서 return
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < oper.length; i++) {
            // 연산자가 1개 이상 있다면 해당 연산자 사용함. 1개 감소시켜줌.
            if (oper[i] >= 1) {
                oper[i] --;
                // i == 0 -> + 연산자를 사용하여 sum값 + 다음 값
                if (i == 0) {
                    DFS(count + 1, sum + A[count]);
                } 
                else if (i == 1) {
                    DFS(count + 1, sum - A[count]);
                } 
                else if (i == 2) {
                    DFS(count + 1, sum * A[count]);
                } 
                else if (i == 3) {
                    DFS(count + 1, sum / A[count]);
                }
                oper[i]++;    
            }
        }
    }
}
