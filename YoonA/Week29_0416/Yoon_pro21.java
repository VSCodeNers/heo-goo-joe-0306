import java.util.*;

class Yoon_pro21 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String answer[] = {};
        String map[] = new String[n];   // 전체 지도
        
        for (int i = 0; i < n; i++) {
            // toBinaryString: 10진수 -> 2진수 변환
            // arr1, arr2 or 계산함
            String single = Integer.toBinaryString(arr1[i] | arr2[i]); 
            
            // 한 변의 길이 n에 부족할 경우 => n 될 때까지 앞에 0 넣어줌
            if (single.length() != n) {
                for (int j = 0; j < n - single.length(); j++) {
                    single = "0" + single;
                }
            }
            // replace 사용하여 1 -> #, 0 -> 공백으로 바꿔줌
            single = single.replace("1", "#");
            single = single.replace("0", " ");
            
            answer[i] = single;
        }
        
        return answer;
    }
}
