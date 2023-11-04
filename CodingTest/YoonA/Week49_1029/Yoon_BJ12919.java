import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_BJ12919 {
    static String S, T;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        DFS(S, T);

        System.out.println(answer);
 
    }
 
    public static void DFS(String S, String T) {
        // S와 T가 같으면 S -> T로 만들 수 있다는 의미니.. 1
        if (S.length() == T.length()) {
            if (S.equals(T)) {
                answer = 1;
            }
            return;
        }

        int ans = 0;

        // T의 첫 글자가 B면
        // B를 제외하고.. 문자열 뒤집는거니까..
        // substring로 첫번째 문자 B 제외한 나머지 문자열만 자른 다음, 뒤집음
        if (T.charAt(0) == 'B') {
            String substring = T.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            DFS(S, string);
        }
 
        // T의 맨 뒤가 A면 마지막 글자 A를 뺌
        if (T.charAt(T.length() - 1) == 'A') {
            DFS(S, T.substring(0, T.length() - 1));
        }
        return;
    }
}