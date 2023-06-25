public class Yoon_pro34 {
    public int solution(int n) {
        int answer = 0;
        int fibo[] = new int[n];
        
        // 처음 두 자리는 1이니까
        fibo[0] = 1; 
        fibo[1] = 1;
        
        // 2부터 시작해서 n번째까지 피보나치 수 구함
        for (int i = 2; i < n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        
        // fibo 배열의 가장 마지막에 있는 값이 n번째 피보나치 수일테니 
        // 총 길이-1번째 든 배열을 answer에 넣음
        answer = fibo[fibo.length - 1];
        return answer;
    }    
}
