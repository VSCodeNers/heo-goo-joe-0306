public class Yoon_Pro {
    public String solution(String new_id) {
        String answer = "";            
        answer = new_id.toLowerCase();  //1단계_문자열을 소문자로 변환하는 함수 사용
        answer = answer.replaceAll("[^a-z0-9-_.]", "");    //2단계_영 소문자, 숫자, -_. 특수문자만 가능하도록 함. 그 외는 제거
        answer = answer.replaceAll("\\.{2,}", ".");   //3단계_.이 2개 이상 입력되면 .으로 바뀌도록 함
        answer = answer.replaceAll("^[\\.]|[\\.]$", "");  //4단계_시작이나 끝이 .이면 제거
    
        if (answer.length() == 0)   //5단계_빈 문자열(길이가 0)이면 a 넣도록 함
            answer = "a";
            
        if (answer.length() >= 16) {    //6단계_길이가 16이상이면 0~15번째만 남게 하고, 나머진 제거
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.')  //만약 끝이 .이면 0~. 앞부분까지만 남도록 함
                answer = answer.substring(0, answer.length() - 1);
            }
            
        if (answer.length() <= 2)      //7단계_길이가 2 이하면 최소 3이 될 때까지 마지막 문자 반복해서 넣음
            while (answer.length() < 3)
                answer += answer.charAt(answer.length() - 1); 
        return answer;
    }
}
