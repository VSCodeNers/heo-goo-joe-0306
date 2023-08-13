import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> mbti = new HashMap<Character, Integer>();
        
        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char key = survey[i].charAt(0);
            
            if (choices[i] == 4) 
                continue;
            if (choices[i] > 4)  
                key = survey[i].charAt(1);
            
            int score = mbti.get(key);
        
            if (choices[i] == 1 || choices[i] == 7) 
                score += 3;
            if (choices[i] == 2 || choices[i] == 6) 
                score += 2;
            if (choices[i] ==3 || choices[i] == 5) 
                score += 1;
            
            mbti.put(key, score);
        } 
        
        StringBuilder sb = new StringBuilder();

        int A = mbti.get('R');
        int B = mbti.get('T');
        if (A > B) 
            sb.append('R');
        else if (A < B)
            sb.append('T');
        else if (A == B) 
            sb.append('R');
        
        A = mbti.get('C');
        B = mbti.get('F');
        if (A > B) 
            sb.append('C');
        else if (A < B)
            sb.append('F');
        else if (A == B) 
            sb.append('C');
        
        A = mbti.get('J');
        B = mbti.get('M');
        if (A > B) 
            sb.append('J');
        else if (A < B)
            sb.append('M');
        else if (A == B) 
            sb.append('J');
        
        A = mbti.get('A');
        B = mbti.get('N');
        if (A > B) 
            sb.append('A');
        else if (A < B)
            sb.append('N');
        else if (A == B) 
            sb.append('A');
        
        return sb.toString();
    }
}