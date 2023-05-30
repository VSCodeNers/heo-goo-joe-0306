//2주차 문제 - 하얀 칸(1100)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] chess = new String[8];
        for(int i = 0; i < 8; i++)
            chess[i] = bf.readLine();

        int cnt = 0;
        //홀수번째 줄 체크
        for(int i = 0; i < 8; i += 2) {
            for(int j = 0; j < 8; j += 2) {
                if(chess[i].charAt(j) == 'F') cnt++;
            }
        }

        //짝수번째 줄 체크
        for(int i = 1; i < 8; i += 2) {
            for(int j = 1; j < 8; j += 2) {
                if(chess[i].charAt(j) == 'F') cnt++;
            }
        }

        System.out.print(cnt);
    }
}
