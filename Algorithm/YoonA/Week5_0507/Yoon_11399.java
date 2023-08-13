import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int people[] = new int[N];    // 사람마다 걸리는 시간
        int total = 0;  // 시간 총 합계

        String[] str = br.readLine().split(" ");    // 띄어쓰기 기준으로 나눔
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(people);    //오름차순 정렬

        int sum = 0;    //이전 대기시간 + 현재 시간  합계..? 
        for (int i = 0; i < people.length; i++) {
            total += people[i] + sum;
            sum += people[i];
        }

        System.out.println(total);
    }
}
