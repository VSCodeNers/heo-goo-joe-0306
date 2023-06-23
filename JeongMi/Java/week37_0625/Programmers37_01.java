// 프로그래머스 - 최솟값 만들기(Lv.2)
import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        int len = A.length;
        
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < len; i++) {
            answer += A[i] * B[len - i - 1];
        }

        return answer;
    }
}