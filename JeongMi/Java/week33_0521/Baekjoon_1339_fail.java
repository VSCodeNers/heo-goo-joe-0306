// 백준 - 단어 수학(1339)
// 실패한 방법
// 같은 자리에 같은 알파벳이 있으면 그거에 제일 큰 값을 주는 게 좋음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon_1339_fail {
  static int N;
  static String[] words;
  static int[] alphabet = new int[26];
  static int[] numbers;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    words = new String[N];
    numbers = new int[N];

    for(int i = 0; i < N; i++) {
      words[i] = bf.readLine();
    }
    
    // 각 알파벳에 숫자 매칭하고 숫자로 변환
    setAlphabet();

    // 합산
    int answer = calculate();

    System.out.print(answer);
  }
  // 각 알파벳에 숫자 배치해주기
  static void setAlphabet() {
    final int maxLength = 8; // 단어의 최대 길이
    int num = 9;

    for(int i = maxLength; i > 0; i--) {
      int index = maxLength - i;
      for(int j = 0; j < N; j++) {
        if(words[j].length() >= i) {
          // index - (maxLenght - words[j].length())
          int indexForWord = index - (maxLength - words[j].length());
          char word = words[j].charAt(indexForWord);
          if(alphabet[word - 'A'] == 0) {
            alphabet[word - 'A'] = num;
            num--;
          }
        }
      }
    }
  }
  // 숫자로 변환 후 계산
  static int calculate() {
    int result = 0;

    for(int i = 0; i < N; i++) {
      result += numbers[i];
    }

    return result;
  }
}