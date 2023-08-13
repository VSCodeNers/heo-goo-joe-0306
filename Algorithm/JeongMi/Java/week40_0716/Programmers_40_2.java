// 프로그래머스 - 짝지어 제거하기(Lv.2)
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i < chars.length;i++) {
            char c = chars[i];
            // 스택이 비어있을 경우
            if (stack.isEmpty())
                stack.push(c);
            // 스택이 비어있지 않을 경우
            else {
                // 이전 문자와 같은지 확인하고, 같다면 이전 문자를 제거
                if (stack.peek() == c) {
                    stack.pop();
                // 다르다면 문자를 스택에 추가
                } else {
                    stack.push(c);
                }
            }
        }
        
        // 결과적으로 스택이 비어있다면 성공
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}