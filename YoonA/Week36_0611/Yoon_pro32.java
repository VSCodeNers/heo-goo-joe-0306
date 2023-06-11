public class Yoon_pro32 {
    public int solution(int n) {
        int answer = 0;
    
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            // n(15)이 될 떄까지 반복하여 숫자를 더함
            // sum == n인 경우에는 연속한 자연수로 표현이 된다는 의미니까 answer+1
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                else if (sum > n) break;
            }
        }
        return answer;
    }
}
