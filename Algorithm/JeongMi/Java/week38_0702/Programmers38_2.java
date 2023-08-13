// 프로그래머스 - 행렬의 곱셈(Lv.2)
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;       // 행
        int column = arr2[0].length; // 열
        int[][] answer = new int[row][column];
        
        // arr1[0].length == arr2.length
        // arr1의 열 길이 = arr2의 행 길이
        int len = arr2.length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                // arr1의 열 index = arr2의 행 index = k
                for(int k = 0; k < len; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}