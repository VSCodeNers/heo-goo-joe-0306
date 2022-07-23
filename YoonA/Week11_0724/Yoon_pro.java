public class Yoon_pro {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int N : numbers) {
            if (N == 0)
                N = 11;
            if (left == 0)
                left = 11;
            if (right == 0)
                right = 11;

            if (N % 3 == 0) { // 3,6,9,12(#)의 경우
                answer += "R";
                right = N;
            } else if (N % 3 == 1) { // 1,4,7,10(*)의 경우
                answer += "L";
                left = N;
            } else if (N % 3 == 2 || N == 0) { // 2,5,8,0의 경우
                int leftD = (Math.abs(N - left) % 3) + (Math.abs(N - left) / 3); // 번호와 왼손의 거리
                int rightD = (Math.abs(N - right) % 3) + (Math.abs(N - right) / 3); // 번호와 오른손의 거리

                if (leftD < rightD) { // 왼손 거리가 더 짧으면
                    answer += "L";
                    left = N;
                } else if (leftD > rightD) { // 오른손 거리가 더 짧으면
                    answer += "R";
                    right = N;
                } else if (leftD == rightD) { // 두손의 거리가 같다면
                    if (hand.equals("left")) { // 왼손잡이
                        answer += "L";
                        left = N;
                    } else if (hand.equals("right")) { // 오른손잡이
                        answer += "R";
                        right = N;
                    }
                }
            }
        }
        return answer;
    }
}
