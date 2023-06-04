import java.util.*; 

public class Yoon_pro31 {
    public String solution(String s) {
        String answer = "";
        String str[] = s.split(" ");    // 문자열 쪼개서 str에 넣음
        
        int number[] = new int[str.length];
        // 문자를 정수로 변환하여 number 배열에 넣음
        for(int i = 0; i < str.length; i++) {
            number[i] = Integer.parseInt(str[i]);
        }
        // 배열 오름차순 정렬함
        // 최소 == 배열의 맨 앞 / 최대 == 배열의 맨 뒤
        Arrays.sort(number);
        answer = number[0] + " " + number[number.length-1];
        
        return answer;
    }
}
