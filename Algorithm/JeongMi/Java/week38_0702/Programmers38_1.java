// 프로그래머스 - 하노이의탑(Lv.2)
class Solution {
  static int index = 0;
  public int[][] solution(int n) {
    int[][] answer = new int[(int)Math.pow(2, n) - 1][2];

    hanoiTop(n, 1, 2, 3, answer);

    return answer;
  }

  static void hanoiTop(int n, int start, int middle, int finish, int[][] answer){
    if(n == 1)
      answer[index++] = new int[] {start, finish};

    else{
      hanoiTop(n-1, start, finish, middle, answer);
      answer[index++] = new int[] {start, finish};
      hanoiTop(n-1, middle, start, finish, answer);
    }
  }
}