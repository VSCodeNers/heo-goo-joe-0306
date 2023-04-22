public class Yoon_pro22 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int x[] = new int[10];
        int y[] = new int[10];
        
        // X, Y 돌면서 한 글자씩 쪼개서 x, y
        for (int i = 0; i < X.length(); i++) {
            x[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i) - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int min = Math.min(x[i], y[i]);
            for (int j = 0; j < min; j++) {
                answer.append(i);
            }
        }
        
        // 짝꿍이 존재하지 않는 경우는 -1 return
        if (answer.length() == 0) 
            return "-1";
        
        // 공통된 숫자가 0뿐일 경우는 0 return
        if (answer.charAt(0) == '0')
            return "0";
        
        return answer.toString();
    }
}
