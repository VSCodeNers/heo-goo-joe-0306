import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ch0 = 0, ch1 = 0;   // ch0: 0 갯수 저장, ch1: 1 갯수 저장
        String S = br.readLine();
        char[] ch = new char[S.length()];   // S 문자열의 길이만큼 배열 공간 생성함

        for (int i = 0; i < ch.length; i++) {
            ch[i] = S.charAt(i);    // S로 입력 받은 걸 ch[i]에 저장?

            if (ch[i] == '0')   // ch[i]가 0이면 ch0 하나 추가, 1이면 ch1 하나 추가
                ch0++;
            else ch1++;
        }

        ch0 /= 2;   // 0과 1 절반을 제거하므로
        ch1 /= 2;
        // 예제 기준으로 1010의 경우 위 식대로 계산하면 ch0 = 1, ch1 = 1임

        // 사전 순으로 가장 빠른 걸 출력해야 되니까 최대한 0이 앞으로, 1이 맨 뒤로 가야된다. 
        // 그니까 1은 맨 앞쪽에서부터 지우고, 0은 맨 뒤쪽에서부터 지움

        for (int i = S.length()-1; i > 0 && ch0 != 0; i--) {    // 0은 배열의 뒤에서부터 지워야 되니까 맨 뒤에서부터 for문 시작
            if (ch[i] == '0') {     // 예제 기준 현재 ch0 = 0인 상태인데 ch0-1이 되었으므로 ch0이 0이 되어 for문 종료 (맨 뒤 0이 지워져서 101가 됨)
                ch0--;
                ch[i] = 0;  // 문자 '0'이 아닌 숫자 0으로 바꿈
            }
        }

        for (int i = 0; i < S.length() && ch1 != 0; i++) {  // 1은 배열의 앞에서부터 지우라고 했으니 
            if (ch[i] == '1') {     // 예제 기준 현재 ch1 = 1인 상태인데 ch1-1이 되었으므로 ch1이 0이 되어 for문 종료 (맨 앞에 1 지워져서 01가 됨)
                ch1--;
                ch[i] = 0;  // 문자 '0'이 아닌 숫자 0으로 바꿈
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (ch[i] != 0)     // ch[i]이 0이 아니면 ch[i]에 들어있는 문자를 sb에 추가 ('0'도 sb에 추가됨)
                sb.append(ch[i]);
        }
        System.out.println(sb);
    }
}
