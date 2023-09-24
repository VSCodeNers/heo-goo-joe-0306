public class Yoon_pro45 {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> strArr1 = new ArrayList<>();
        List<String> strArr2 = new ArrayList<>();

        List<String> union = new ArrayList<>();         // 합집합
        List<String> intersection = new ArrayList<>();  // 교집합


        // str1 문자열 2개로 쪼개고 strArr1에 넣음
        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            
            // 해당 char가 영문자인지 확인
            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                strArr1.add(first + "" + second);
            }
        }

        // str2 문자열 2개로 쪼개고 strArr2에 넣음
        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            // 해당 char가 영문자인지 확인
            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                strArr2.add(first + "" + second);
            }
        }

        // 만약 strArr2 중에 strArr1에 있는 문자열이 있다면
        // strArr2에서 해당 문자열 삭제하고, 교집합에 추가
        for (String st : strArr1) {
            if (strArr2.remove(st)) {
                intersection.add(st);
            }
            union.add(st);
        }

        // str2를 합집합에 넣음
        // 위에서 교집합이 될만한 부분은 제거 했으니까 str2를 union에 넣기만 하면 합집합임
        for(String st : strArr2) {
            union.add(st);
        }

        double jakard = 0;
        
        // 합집합이 0이면 아무것도 없는 공집합.. 그니까 1
        if (union.size() == 0) 
            jakard = 1;
        
        else 
            jakard = (double)intersection.size() / (double)union.size();
        // 자카드 구한 값에 65536 곱해주고.. 소수점 버리라했으니 int형으로 변환
        int answer = (int)(jakard * 65536);
        
        return answer;
    }
}
