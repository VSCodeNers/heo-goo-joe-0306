// 프로그래머스 : 햄버거 만들기(Lv.1) -- 성공
import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        // 빵 - 야채 - 고기 - 빵: 1231
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int ingre : ingredient) {
            // 재료를 하나씩 쌓는다
			stack.push(ingre);
            // 4개 이상 쌓이면 햄버거를 만들 수 있는지 체크
			if (stack.size() >= 4) {
				int size = stack.size();
                // 1, 2, 3, 1의 순서로 들어가있을 경우
                // 뒤(위)에서부터 확인하니까 역순으로 1, 3, 2, 1
				if(stack.get(size - 1) == 1
						&& stack.get(size - 2) == 3
						&& stack.get(size - 3) == 2
						&& stack.get(size - 4) == 1) {
                    // 햄버거 하나 완성
					answer++;
                    // 사용한 재료는 제거
					stack.pop();
					stack.pop();
					stack.pop();
					stack.pop();
				}
			}
		}
        
        return answer;
    }
}