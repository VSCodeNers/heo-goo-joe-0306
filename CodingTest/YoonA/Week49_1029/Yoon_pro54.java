public class Yoon_pro54 {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        int period = 0;
        
        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            period = 0;
            
            // 현재 가격이 다음 가격보다 더 큰 경우
            // 가격이 하락한다는 소리니까.. break하고 period를 answer[i]에 담음
            for (int j = i + 1; j < prices.length; j++) {
                period++;
                if (now > prices[j]) {
                    break;
                }
            }
            answer[i] = period;
        }
        return answer;
    }
}
