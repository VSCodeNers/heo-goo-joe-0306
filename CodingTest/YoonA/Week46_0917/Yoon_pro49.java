public class Yoon_pro49 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 정규식을 사용해서 숫자부분 자르고 앞에 문자만 비교를 위해 0번째 문자열 대문자로 치환
                String head1 = s1.split("[0-9]")[0].toUpperCase();
                String head2 = s2.split("[0-9]")[0].toUpperCase();
                
                int compareHead = head1.compareTo(head2);
                
                // head로 비교 가능한 경우 바로 headCompare return, head로 비교가 불가할 경우 뒤에 있는 숫자로 판별
                return compareHead == 0 
                    ? getNumber(s1.substring(head1.length())) - getNumber(s2.substring(head2.length()))
                    : compareHead;
            }
        });
        
        return files;
    }
    
    public int getNumber(String s) {
        String num = "";
        for (char c : s.toCharArray()) {
            // c가 숫자이면서 결과 길이가 5 미만일 경우 결과에 c 추가
            if (Character.isDigit(c) && num.length() < 5) {
                num += c;
            } else break;
        }
        return Integer.parseInt(num);
    }
}
