// 백준 - N과M9(15663)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class BeakJoon_15663 {
    static int[] num, arr;
    static boolean[] visited;
    static int N, M;
    static LinkedHashSet<String> result = new LinkedHashSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬
        NandM9(0);

        // Iterator를 이용해 HashSet 출력
        Iterator iter = result.iterator();
        StringBuilder printSet = new StringBuilder();
        while(iter.hasNext()) {
            printSet.append(iter.next() + "\n");
        }
        System.out.print(printSet);
    }
    static void NandM9(int cnt) {
        if(cnt == M) {
            StringBuffer set = new StringBuffer();
            for(int i = 0; i < M; i++) {
                set.append(arr[i]).append(" ");
            }
            result.add(set.toString()); // set에 저장하면 중복되는 값 없이 저장됨
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = num[i];
                NandM9(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
