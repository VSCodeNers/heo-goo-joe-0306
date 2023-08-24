import java.util.ArrayList;

public class Yoon_pro43 {
    public int[] solution(int n, String[] words) {
        int answer[] = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);                                     // 여기 단어 담음
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];                         // 이전 단어
            String now = words[i];                              // 현재 단어
                
            char prev_last = prev.charAt(prev.length() - 1);    // 이전 단어의 마지막 문자
            char now_first = now.charAt(0);                     // 현재 단어의 시작 문자
            
            // list 내에 words[i]번째에 해당되는 단어가 있다면 나온 적 있는 단어가 또 나왔다는 뜻이고
            // + 현재 단어의 시작 문자와 이전 단어의 마지막 문자가 같지 않다면.. 이것도 안되니까
            // 위 두 조건에 해당될 경우 answer 안에 번호랑 차례 넣어서 break;
            if (list.contains(words[i]) || prev_last != now_first) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1; 
                    
                break;
            }   
            
            // if 조건에 해당 안되면 list에 현재 문자 추가함
            list.add(words[i]);
        }

        return answer;
    }
}
