//1주차 문제 - OX퀴즈(8958)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); //테스트 케이스 개수
        for(int i = 0; i < N; i++) {
            String oxCheck = bf.readLine();
            System.out.println(CheckScore(oxCheck));
        }
        
    }
    static int CheckScore(String ox) {
        int score = 0, check = 0;
        for(int i = 0; i < ox.length(); i++) {
            if(ox.charAt(i) == 'O') {
                check++;
                score += check;
            }
            else if(ox.charAt(i) == 'X') check = 0;
        }
        return score;
    }
}
