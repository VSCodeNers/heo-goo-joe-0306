// 백준 - N과M10(15664)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class BeakJoon_15664 {
    static int N, M;
    static int[] num;
    static LinkedHashSet<String> result = new LinkedHashSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 오름차순 정렬
        NandM10(0, "", 0);

        // Iterator를 이용해 HashSet 출력
        Iterator iter = result.iterator();
        StringBuilder printSet = new StringBuilder();
        while(iter.hasNext()) {
            printSet.append(iter.next() + "\n");
        }
        System.out.print(printSet);
    }
    static void NandM10(int cnt, String sequence, int pre) {
        if(cnt == M) { // 길이가 M인 수열이 만들어진 경우
            result.add(sequence);
            return;
        }
        for(int i = pre; i < N; i++) {
            NandM10(cnt + 1, sequence + num[i] + " ", i+1);
        }
    }
}
