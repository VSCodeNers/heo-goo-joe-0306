import java.util.*;

public class Yoon_pro20 {
    public int solution(String dartResult) {
        int score[] = new int[3];    // 3번 기회 있으니까 각 기회 별로 얻은 점수 넣으려고
        int answer = 0;
        int temp = 0;
        int index = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            // 하나하나 다 쪼갬
            char dart = dartResult.charAt(i);
            
            // Character.isDigit: 문자인지 숫자인지 판별. true == 숫자, false == 문자
            if (Character.isDigit(dart)) {
                if (dart == '1' && dartResult.charAt(i+1) == '0') {
                    temp -= Integer.parseInt(String.valueOf(dart));
                    temp = 10;
                    i++;
                }
                else {
                    // temp에 dart 값을 넣음. char -> int 형 변환
                    temp = Character.getNumericValue(dart);
                }
            }
            
            else {
                if (dart == 'S') {
                    // Math.pow() : 제곱 
                    score[index] = (int) Math.pow(temp, 1);
                    // n번째 기회 때 얻은 점수 계산했으니 다음 n+1번째 해야될거 아닙니까
                    index++; 
                    // 0으로 초기화 해줘야 다음 기회 때 얻은 점수만 온전히 알 수 있으니..?
                    // 초기화 안하면 현재 점수 + 다음 점수 섞이니까
                    temp = 0;
                }
                
                if (dart == 'D') {
                    // 위와 동일
                    score[index] = (int) Math.pow(temp, 2);
                    index++; 
                    temp = 0;
                }
                
                if (dart == 'T') {
                    // 위와 동일
                    score[index] = (int) Math.pow(temp, 3);
                    index++; 
                    temp = 0;
                }
                
                // 스타상이면 점수 해당 점수 && 이전 점수가 두배
                if (dart == '*') {
                    score[index-1] *= 2;
                    // 첫번째 기회가 아니라면 이전번째도 2배해줘야 하니깐
                    if (index >= 2) 
                        score[index-2] *= 2;
                }
                
                // 아차상이면 해당 점수 자체가 마이너스가 됨
                if (dart == '#') {
                    score[index-1] *= -1;
                }
            }
        }
        
        // 각 기회 별로 얻은 점수 합산하여 return
        answer = score[0] + score[1] + score[2];
        
        return answer;
    }
}