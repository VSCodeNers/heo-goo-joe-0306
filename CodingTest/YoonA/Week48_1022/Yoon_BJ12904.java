import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_BJ12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            char last = T.charAt(T.length() - 1);
            // 맨 마지막 문자만 쏙 지움
            T = T.deleteCharAt(T.length() - 1);

            // 문자열 맨 뒤가 B라면? 문자 뒤집음
            if (last == 'B') {
                T.reverse();
            }
        }

        // 같으면 s -> T 만들 수 있다는 의미니.. 1 출력, 아니면 0 출력
        if (T.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
