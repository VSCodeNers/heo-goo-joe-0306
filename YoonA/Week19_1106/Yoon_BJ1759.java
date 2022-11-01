import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ1759 {
    public static int L, C;
    public static char ch[];
    public static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        ch = new char[C];
        check = new boolean[C];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            ch[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);

        DP(0, 0);
    }

    public static void DP(int start, int count) {
        int vowel = 0;          // 모음
        int consonant = 0;      // 자음
        String password ="";

        for (int i = start; i < C; i++) {
            check[i] = true;
            DP(i+1, start+1);
            check[i] = false;
        }
        if (count == C) {
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(password);
            }

            for (int i = 0; i < C; i++) {
                if (check[i] == true) {
                    password += ch[i];

                    if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                        vowel++;
                    }
                    else {
                        consonant++;
                    }
                }
            }
        }
    }
}
