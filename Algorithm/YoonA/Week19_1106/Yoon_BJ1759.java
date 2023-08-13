import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yoon_BJ1759 {
    public static int L, C;
    public static char password[];
    public static char ch[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new char[C];
        password = new char[C];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            ch[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);

        DP(0, 0);
    }

    public static void DP(int start, int count) {
        if (count == L) {
            if (check()) {
                for (int i = 0; i < L; i++) {
                    System.out.print(password[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < C; i++) {
                password[count] = ch[i];
                DP(i+1, count+1);
        }
    }

    public static boolean check() {
        int vowel = 0;          // 모음
        int consonant = 0;      // 자음

        for (int i = 0; i < C; i++) {
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' 
                    || password[i] == 'o' || password[i] == 'u') {
                vowel++;
            }
            else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}
