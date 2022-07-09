public class Yoon_Pro {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int good = 0, bad = 0;          //최고 순위, 최저 순위 기록
        int bingo = 0, zero = 0;        //숫자가 일치하는 경우, 0인 경우 카운트
        
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j])
                    bingo++;
            }
            if (lottos[i] == 0)
                zero++;                    
        }
        
        good = rank[zero + bingo];
        bad = rank[bingo];
        
        int[] answer = {good, bad};
        return answer;
    }
}
