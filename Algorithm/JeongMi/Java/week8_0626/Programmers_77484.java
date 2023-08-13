// 프로그래머스 - 로또의 최고 순위와 최저 순위(Lv.1)
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correct = 0, zero = 0;
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) zero++; // 0 갯수 세기
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]) { // 당첨 번호와 일치하는 번호 수 세기
                    correct++;
                    break;
                }
            }
        }
        
        answer[0] = 7 - (correct + zero); // 최고 순위
        answer[1] = 7 - correct; // 최저 순위
        if(answer[0] == 7) answer[0]--;
        if(answer[1] == 7) answer[1]--;
        
        return answer;
    }
}
