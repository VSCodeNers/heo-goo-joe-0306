public class Yoon_pro41 {
    public int solution(int n) {
        int result = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                result++;
            }
        }
        return result;
    }
}
