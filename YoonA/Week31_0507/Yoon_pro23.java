public class Yoon_pro23 {
    public int solution(int[] number) {
        int answer = 0; 
        
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i+1; j < number.length - 1; j++) {
                for (int k = j+1; k < number.length; k++) {
                    int trio = number[k] + number[j] + number[i];
                    
                    if (trio == 0) 
                        answer++;
                }
            }
        }
        return answer;
    }        
}
