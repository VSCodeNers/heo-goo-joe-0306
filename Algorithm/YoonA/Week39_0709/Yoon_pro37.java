public class Yoon_pro37 {
    public String solution(String s) {
        String answer = "";
    	String[] str = s.split(" "); // " " 기준으로 문자열 잘라서 배열에 넣음
        
    	for(int i = 0; i < str.length; i++) {
    		String now = str[i];
    		
    		// 현재 문자열이 공백이면 answer에 " "만 추가
    		if(str[i].length() == 0) answer += " ";
            
    		else {
    			// 처음 문자는 대문자로 바꾸고, 나머지 뒤 문자들은 소문자로
    			answer += now.substring(0, 1).toUpperCase();
    			answer += now.substring(1, now.length()).toLowerCase();
    			answer += " ";
    		}
    	}
    	
    	// 문자열 맨 마지막이 공백이면 바로 answer 반환
    	if (s.substring (s.length() - 1, s.length()).equals(" ")) {
    		return answer;
    	}
        
    	// 맨 마지막 공백 제거하고 answer 반환
        return answer.substring(0, answer.length() - 1);
    }
}
