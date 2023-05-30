// 백준 - 모든 순열(10974)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BeakJoon_10974 {
    static int N;
    static int[] num;
    static boolean[] isSelected;
    static StringBuilder printSet = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N];
        isSelected = new boolean[N];

        allPerm(0);
        
        System.out.print(printSet);
    }
    static void allPerm(int cnt) {
        if(cnt == N) {
            for(int i = 0; i < N; i++) {
                printSet.append(num[i]).append(" ");
            }
            printSet.append("\n");

            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            num[cnt] = i + 1;
            isSelected[i] = true;

            allPerm(cnt + 1);
            isSelected[i] = false;
        }
    }
}