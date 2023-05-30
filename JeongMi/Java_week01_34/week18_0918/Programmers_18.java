// 프로그래머스 - 나머지가 1이 되는 수 찾기(Lv. 1)

class Solution {
    public int solution(int n) {
        int answer;
        
        for(int i = 2; ; i++) {
            if(n%i == 1) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}