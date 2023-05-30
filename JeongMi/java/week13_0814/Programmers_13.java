// 프로그래머스: 없는 숫자 더하기(Lv.1)
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i = 1; i <= 9; i++) {
            if(!contain(i, numbers))
                answer += i;
        }
        
        return answer;
    }
    static boolean contain(int value, int[] numbers) {
        for(int num : numbers) {
            if(value == num) return true;
        }
        return false;
    }
}