// 프로그래머스 - 신규 아이디 추천(Lv.1)

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        
        // 1단계: 모든 대문자를 소문자로 치환
        answer = answer.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        String save_string = "[^0-9a-z._-]";
        answer = answer.replaceAll(save_string, "");
        
        // 3단계: 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        answer = answer.replaceAll("\\.+", ".");
        
        // 4단계: 마침표가 처음이나 끝에 위치한다면 제거
        if(answer.charAt(0) == ".".charAt(0)) {
            answer = answer.substring(1);
        }
        // 문자열의 길이가 0인 경우 -1번 방이 존재하지 않는데 탐색하라고 해서 오류가 발생함. 0 이상인 것들만 탐색하도록 제어.
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == ".".charAt(0)) {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        // 5단계: 빈문자열이라면 "a" 대입
        if(answer.equals("")) answer = "a";
        
        // 6단계: 길이가 16자 이상일 경우, 첫 15개의 문자만 남기고 제거
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            // if - 제거 후 마침표가 맨 끝에 위치한다면 제거
            if(answer.length() > 0 && answer.charAt(answer.length() - 1) == ".".charAt(0)) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 7단계: 길이가 2자 이하라면 길이가 3이 될 때까지 마지막 문자를 반복해서 끝에 붙임
        if(answer.length() <= 2) {
            String copy_word = String.valueOf(answer.charAt(answer.length() - 1));
            while(answer.length() < 3) {
                answer += copy_word;
            }
        }
        
        return answer;
    }
}