public class Yoon_pro29 {
    // number : 기사단원의 수
    // limit : 공격력의 제한수치
    // power : 제한 수치를 초과한 기사가 사용할 무기 공격력
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 약수 구해줌
        for(int i = 1; i <= number; i++) {
            int divisor = 0;    // 약수 개수
            
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) 
                    divisor++; 
                
                // i, j 둘 다 약수라는 의미니까 개수 +2
                else if (i % j == 0) 
                    divisor += 2; 
            }
            
            // 약수의 개수가 제한수치를 넘어갈 경우
            if (divisor > limit) 
                // 제한 수치를 넘어간 사람은 power를 구매해야 함
                answer += power; 
            
            // 약수의 개수가 제한수치를 넘어가지 않았다면?
            // 해당 약수의 개수만큼 공격력을 갖는 무기 구매
            else 
                answer += divisor; 
        } 
        return answer;
    }
}
