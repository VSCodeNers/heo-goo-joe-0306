// 덩치(7568)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Num7568 {
    static int[] weight;
    static int[] height;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        weight = new int[N];
        height = new int[N];
        rank = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;  i < N; i++) {
            rank[i] = 1;
            for(int j = 0; j < N; j++) {
                if(weight[i] < weight[j] && height[i] < height[j]) {
                    rank[i]++;
                }
            }
        }

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < N; i++)
            printSet.append(rank[i]).append(" ");
        
        System.out.print(printSet);
    }
}
