import java.util.*;

public class Yoon_pro26 {
    // k : 최상품 사과의 점수
    // m : 한 상자에 들어갈 사과 개수
    // score : 사과 점수
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // score 오름차순
        Arrays.sort(score);
        
        // 배열 뒤부터 m개씩 과일 나눔
        for (int i = score.length - 1; i >= 0 ; i--) {
            // score 내에서 m개씩 나눠야 하니까 나머지가 0인 경우에만 계산
            // 배열 맨뒤부터 i씩 앞으로 이동
            if ((score.length - i) % m == 0) {
                // 하나의 상자 안에서 최하위 사과의 점수는 해당 i번째 사과임
                // 계산식 : 최저사과(score[i]) * 한 상자의 사과 수(m) * 상자 개수
                answer += m * score[i];
            }
        }
        return answer;
    }
}
