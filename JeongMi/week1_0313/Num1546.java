//1주차 문제 - 평균(1546)
package JeongMi.week1_0313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num1546 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); //시험 본 과목의 개수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] oriScore = new int[N]; //현재 성적
        for(int i = 0; i < N; i++)
            oriScore[i] = Integer.parseInt(st.nextToken());
        
        //현재 성적 중 최대 점수 탐색 및 총점 계산
        int max = 0, total = 0;
        for(int i = 0; i < N; i++) {
            if(max < oriScore[i]) max = oriScore[i];
            total += oriScore[i];
        }

        double newAvg = 100.0 * total / max / N;
        //toal, max, N이 int형이기 때문에 연산을 했을 때 소수점을 버리고 몫만 나온다.
        //때문에 100.0을 먼저 곱해서 실수로 만든 뒤 나머지 계산을 해야 오류가 없다.

        System.out.print(newAvg);
    }
}
