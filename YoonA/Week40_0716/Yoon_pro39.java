public class Yoon_pro39 {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> st = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            // 문자 하나씩
            char c = s.charAt(i);
            // 스택에 값이 들어있고, 최근에 들어간 요소가 c랑 같으면 st에서 제거
            if (!st.isEmpty() && st.peek() == c)
                st.pop();
            // 스택 최근 값이 현재 문자랑 다르면 push
            // 반복이 아니라는 소리니
            else
                st.push(c);
        }
        // 스택이 모두 비어있다면 문자열이 전부 짝지어져 있다는 소리니까 1 반환
        return st.isEmpty() ? 1 : 0;
    }
}
