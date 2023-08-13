// 프로그래머스 - [1차] 비밀지도
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for(int i = 0 ; i < n ; i++){
        // 이진수를 or로 하면 1이 하나라도 있으면 1로 처리됨.
        String binary
            = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
        
        // 위에서 이진수로 변환할 때 16자리로 받음
        // 0000000000011111 이런식이므로 앞에 필요없는 부분을 잘라줌
        binary = binary.substring(binary.length() - n);
        
        // 1, 0을 #, 공백으로 바꿔서 처리
        binary = binary.replaceAll("1", "#"); // 벽
        binary = binary.replaceAll("0", " "); // 공백
        
        answer[i] = binary;
    }

    return answer;
  }
}