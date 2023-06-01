// 백준 - 수 이어 쓰기 1(1748)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BeakJoon_1748 {
    static public void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // N이 몇째자리 숫자인지
        int numberOfDigits = 0;
        int check = N;
        while(check > 0) {
            numberOfDigits++;
            check /= 10;
        }

        int answer = 0;
        if(numberOfDigits == 1) {
            answer += N * numberOfDigits;
        }
        else {
            int ten = 1;
            for(int i = 1; i < numberOfDigits; i++) { // 1의 자리부터 numberOfDigits-1의 자리까지 카운트
                answer += 9 * ten * i;
                // 1의 자리: 9개 * 1
                // 10의 자리: 99-9 = 90개 * 2
                // 100의 자리: 999-90-9 = 900개 * 3
                ten *= 10;
            }
            
            // numberOfDigits의 자리까지 카운트
            answer += (N - ten + 1) * numberOfDigits;
        }

        System.out.print(answer);
    }
}