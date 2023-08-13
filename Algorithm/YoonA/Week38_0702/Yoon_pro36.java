public class Yoon_pro36 {
    public static int[][] answer;
    public static int x = 0;
    
    public int[][] solution(int n) {
      int num = (int)Math.pow(2, n) - 1;    
      answer = new int[num][2];          
      hanoi(n, 1, 2, 3);
      return answer;
    }
    
    public static void hanoi(int n, int start, int other, int end) {
        if(n == 0)
              return;
        hanoi(n-1, start, end, other);  
        answer[x][0] = start; 
        answer[x++][1] = end;          
        hanoi(n-1, other, start, end);  
    }
}
