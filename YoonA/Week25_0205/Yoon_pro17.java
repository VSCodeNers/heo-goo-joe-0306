import java.util.*;

public class Yoon_pro17 {
    public int[] solution(int[] answers) {
        int count[] = {0, 0, 0};                        // 순서대로 1,2,3 정답 개수
        int stu1[] = {1, 2, 3, 4, 5};                   // 1번 수포자
        int stu2[] = {2, 1, 2, 3, 2, 4, 2, 5};          // 2번 수포자
        int stu3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    // 3번 수포자
        
        for (int i = 0; i < answers.length; i++) {
            // 1번 학생이 찍은 답과 정답이 일치한다면 count[0] + 1 (정답갯수 +1)
            if (answers[i] == stu1[i % stu1.length]) {
                count[0]++;
            }
                
            // 2번, 3번 경우도 위와 동일함
            if (answers[i] == stu2[i % stu2.length]) {
                count[1]++;
            }
                
            if (answers[i] == stu3[i % stu3.length]) {
                count[2]++;
            }
        }
        
        // 최대값 비교
        // count[0]이 최댓값이면 1번, count[1]이 최댓값이면 2번, count[2]이 최댓값이면 3번
        // result arraylist에 추가
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        ArrayList<Integer> result = new ArrayList<>();
        if (max == count[0])
            result.add(1);
        if (max == count[1])
            result.add(2);
        if (max == count[2])
            result.add(3);
        
        // 오름차순 정렬
        Collections.sort(result);
        
        // 결과값을 answer 배열로 옮김
        int answer[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
