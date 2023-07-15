public class Yoon_pro40 {
    public int solution(int[] arr) {
        int answer = 0;
    
        // 최대공약수 구하기
        int gcd = GCD(arr[0], arr[1]);
        // 최소공배수 구하기
        int lcm = arr[0] * arr[1] / gcd;
        //i번째 최대공약수랑 최소공배수를 쭉 구해줌
        // 마지막으로 구한게 배열 내 모든 수 최소공배수
        for (int i = 2; i < arr.length; i++) {
            gcd = GCD(lcm, arr[i]);
            lcm = lcm * arr[i] / gcd;
        }
        
        answer = lcm;
        
        return answer;
    }
    
    public static int GCD(int a, int b) {
        if(a % b == 0) return b;
            return GCD(b, a % b);
    }
}
