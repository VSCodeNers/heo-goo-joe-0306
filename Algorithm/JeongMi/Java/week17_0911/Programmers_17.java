// 프로그래머스 - 최소 직사각형
class Solution {
    public int solution(int[][] sizes) {
        int answer;
        int width = 0, height = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            width = Math.max(width, max);
            height = Math.max(height, min);
        }
        
        answer = width * height;
        
        return answer;
    }
}