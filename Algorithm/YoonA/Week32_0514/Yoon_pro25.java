public class Yoon_pro25 {
    public int solution(String[] babbling) {
        int answer = 0;
        String possible[] = {"aya", "ye", "woo", "ma"};                 // 할 수 있는 발음
        String impossible[]  = {"ayaaya", "yeye", "woowoo", "mama"};    // 못하는 발음
        
        for (int i = 0; i < babbling.length; i++) {
            // contains: 포함되어 있는지 확인하는 거
            // babbling에 있는 발음 중에 못하는 발음이 포함되어 있는 경우, 그냥 넘어감
            if (babbling[i].contains(impossible[0]) ||
                babbling[i].contains(impossible[1]) || 
                babbling[i].contains(impossible[2]) || 
                babbling[i].contains(impossible[3])) {
                continue;
            }
            
            // replace: possible[x]번째 단어가 babbling 안에 포함되어 있는 경우, " "으로 교체
            babbling[i] = babbling[i].replace(possible[0], " "); 
            babbling[i] = babbling[i].replace(possible[1], " "); 
            babbling[i] = babbling[i].replace(possible[2], " "); 
            babbling[i] = babbling[i].replace(possible[3], " "); 
            // ""으로 설정할 경우, babbling[i] 앞뒤에 있던 문자들이 서로 붙어서 새로운 단어가 만들어 질 수 있음
            // ex) ayyea -> ye 빠지면 aya 이렇게
            // -> 그래서 " "으로 함 (다른 문자 넣어도 ㅇㅋ)
            babbling[i] = babbling[i].replace(" ", ""); 
            // babbling[i]가 "" 밖에 없다는건 해당 배열에 들어있던 발음이 다 할 수 있는 발음이라는 뜻이니 answer 증가
            if (babbling[i].equals("")) answer++;
        }
        return answer;
    }
}
