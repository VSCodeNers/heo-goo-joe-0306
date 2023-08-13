import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_BJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Alphabet[] = new int[26];

        for (int i = 0; i < N; i++) {
            // 알파벳 하나씩 입력받음
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                // 알파벳 개수 체크할 때, 자릿수만큼 10의 거듭제곱을 해줌
                Alphabet[str.charAt(j) - 'A'] += (int)Math.pow(10, str.length() - j - 1);
            }
            // GCF : 100G + 10C + 1F
            // ACDEB : 10000A + 1000C + 100D + 10E + 1B 이렇게
        }

        Arrays.sort(Alphabet);

        int sum = 0;
        int num = 9;    

        // 알파벳 개수 파악
        for (int i = 25; i >= 0; i--) {
            // i번째가 0이면 해당 순서 알파벳이 없다는 의미니까 패스
            if (Alphabet[i] == 0) {
                continue;
            }

            // i번째에 알파벳이 있따?
            // 제일 자리수가 높은 애부터 9, 8,7.. 순서대로 할당
            sum += (Alphabet[i] * num);
            num--;
        }
        System.out.println(sum);
    }
    
}
