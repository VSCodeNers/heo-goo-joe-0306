import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Yoon_BJ11723 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int N;

            switch(str) {
                case "add":
                    N = Integer.parseInt(st.nextToken());
                    set.add(N);
                    break;

                case "remove":
                    N = Integer.parseInt(st.nextToken());
                    set.remove(N);
                    break;

                case "check":
                    N = Integer.parseInt(st.nextToken());

                    if(set.contains(N)) 
                        sb.append("1\n");
                    else 
                        sb.append("0\n");
                    break;

                case "toggle":
                    N = Integer.parseInt(st.nextToken());

                    if(set.contains(N)) 
                        set.remove(N);
                    else   
                        set.add(N);
                    break;

                case "all":
                    for (int j = 1; j <= 20; j++)
                        set.add(j);
                        break;

                case "empty":
                    set.clear();
                    break;
            }   
        }
        System.out.println(sb.toString());
    }
}

/* 26
1101    1101
0101    0101
0110    0001
0010    0010
 */