// 프로그래머스 - 줄 서는 방법(Lv.2)
import java.util.ArrayList;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        ArrayList<Integer> people = new ArrayList<>();
        long factorial = 1;
        int index = 0;
        
        // 사람
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            people.add(i);
        }
        
        k--;
        
        while(n > 0) {
            // 해당 자리에 들어갈 수 있는 경우의 수
            factorial /= n;
            
            // 해당 자리의 숫자
            int val = (int) (k / factorial);
            // 정답 배열에 숫자 삽입
            answer[index] = people.get(val);
            people.remove(val);
            
            // 다음 자리수 계산을 위해 k값 변경
            k %= factorial;
            index++;
            n--;
        }
        
        return answer;
    }
}