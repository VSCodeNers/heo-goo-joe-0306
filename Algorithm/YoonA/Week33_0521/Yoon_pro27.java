public class Yoon_pro27 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        int left = 0;
        
        // food 배열 안 숫자를 나누기 2 해서 left에 담아줌
        for (int i = 1; i < food.length; i++) {
            left = food[i] / 2;
            // 그냥 sb에 추가하면 1230 이런 식으로 숫자가 하나씩 밖에 안 들어감..
            // for 하나 더 만들어서 left만큼 반복
            // food[i](4)/2 -> 2라면? 내부 for문 2번 돌려서 sb에 2를 두번 넣어라 ~~
            for (int j = 0; j < left; j++) sb.append(i);
        }
        
        // sb 안에 담긴 값 + 가운데 0 넣어주고 + sb 거꾸로 또 출력한 걸 answer에 담음
        answer = sb.toString() + "0" + sb.reverse().toString();
        
        // for (int i = right; i >= 0; i--) {
        //     answer += right.charAt(i);
        // }
        
        return answer;
    }
}
