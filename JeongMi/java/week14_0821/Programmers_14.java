// 프로그래머스 - 음양 더하기 (Lv.1)
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}
