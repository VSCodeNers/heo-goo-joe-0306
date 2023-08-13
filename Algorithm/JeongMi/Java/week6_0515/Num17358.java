//복불복으로 지구 멸망(17358)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num17358 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long cnt = 1; // 값이 많이 커질 수 있으므로 long으로!
        double check = Math.pow(10, 9) + 7; //10^9 + 7

        while(N > 2) {
            cnt *= N-1;
            cnt %= check;
            N -= 2;
        }

        System.out.print(cnt);
    }
}
/*
2개 - 1번
4개 - 3번 = (4-1)*2개의 개수
6개 - 15번 = 5*3 = (6-1)*4개의 개수
8개 = (8-1)*6개의 개수 = 7 * 15
*/