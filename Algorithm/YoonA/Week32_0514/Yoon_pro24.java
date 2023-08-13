public class Yoon_pro24 {
    // 1: 빵, 2: 야채, 3: 고기
    // 햄버거: 빵 - 야채 - 고기 - 빵 / 1 - 2 - 3 - 1
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < ingredient.length; i++) {
            //sb 안에 ingredient 하나씩 넣어줌 -> 넣은 순서대로 쌓이겠죠?
            sb.append(ingredient[i]);
            
            if (sb.length() >= 4) {
                // 1321일 경우, 1231 순서대로 햄버거가 제대로 완성 됐다는 의미니까 answer 1 더함
                if (sb.charAt(sb.length() - 1) == '1') {
                    if (sb.charAt(sb.length() - 2) == '3') {
                        if (sb.charAt(sb.length() - 3) == '2') {
                            if (sb.charAt(sb.length() - 4) == '1') {
                                // 문자 넣어둔걸 다시 비워줌
                                sb.delete(sb.length() - 4, sb.length());
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
