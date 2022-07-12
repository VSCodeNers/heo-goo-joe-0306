// 프로그래머스 - 숫자 문자열과 영단어(Lv.1)
// 처음 생각한 방법으로 구현하니까 60점이 나옴. 솔루션 찾아봄.

class Solution {
    //static String[] number;
    //static int answer;
    public int solution(String s) {
        int answer;
        
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        String[] englishWords = {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
        for (int i = 0 ; i <10 ; i++){
            s = s.replace(englishWords[i] , numbers[i]);
        }
        answer = Integer.parseInt(s);
        
        return answer;
        
        /*
        number = new String[10];
        number[0] = "zero";
        number[1] = "one";
        number[2] = "two";
        number[3] = "three";
        number[4] = "four";
        number[5] = "five";
        number[6] = "six";
        number[7] = "seven";
        number[8] = "eight";
        number[9] = "nine";
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > 'a') { // 문자열 s의 i번째 문자가 알파벳인 경우
                int cnt = 0;
                String check = String.valueOf(s.charAt(i));
                for(int j = i+1; j < s.length(); j++) {
                    if(s.charAt(j) > 'a') {
                        check += String.valueOf(s.charAt(j));
                        cnt++;
                    }
                    else break;
                }
                i += cnt; // 영단어에 해당하는 부분만큼 스킵(?)

                int changeNum = changeToNumber(check);
                answer += changeNum;
            }
            else { // 문자열 s의 i번째 문자가 숫자인 경우
                answer = answer * 10 + (s.charAt(i) - '0');
            }
        }
        
        return answer;
        */
    }
    /*
    static public int changeToNumber(String stringNumber) { // 영단어를 숫자로 바꿔주는 함수
        int returnNum = 0;
        int strNumLen = stringNumber.length();
        for(int i = 0; i < 10; i++) {
            int len = number[i].length();
            if(strNumLen >= len && number[i].equals(stringNumber.substring(0, len))) {
                returnNum = i;
                if(strNumLen >= (len+1)) { // 뒤에 문자가 더 남아있는 경우 = 영단어가 연달아 올 경우
                    returnNum *= 10;
                    returnNum += changeToNumber(stringNumber.substring(len, strNumLen));
                }
                answer *= 10; // 영단어가 차지하는 자릿수만큼 10을 곱해서 자릿수 맞추기
                break;
            }
        }
        return returnNum;
    }*/
}
