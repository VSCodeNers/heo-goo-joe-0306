public class Yoon_pro44 {
    public int solution(int n, int a, int b) {
        // 1 2 / 3 4 / 5 6 / 7 8
        // 여기서 4는 2라운드, 7은 4라운드임..
        // 4/2 = 2니까, 7/2 = 3에다가 나머지 1 더해서 4
        // 긍께 짝수는 그냥 /2, 홀수는 /2에 나머지 더한 값
        int answer = 0;
        
        while (a != b) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            
            answer++;
        }

        return answer;
    }
}