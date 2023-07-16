// 프로그래머스 - N개의 최소공배수(Lv.2)
class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            // 최소공배수 = (n1 * n2) / (n1, n2의 최대공약수)
            lcm = (lcm * arr[i]) / GCD(lcm, arr[i]);
        }
        
        return lcm;
    }

    // 최대공약수
    static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);
    }
}