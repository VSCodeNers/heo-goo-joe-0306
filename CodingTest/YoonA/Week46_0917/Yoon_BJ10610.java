import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yoon_BJ10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		String str = br.readLine();
		int sum = 0;

        // 30 배수가 되는 수를 찾기 위해서는 
        // 1. 맨 끝 숫자가 0
        // 2. 각 자리 수의 합이 3으로 나눠 떨어져야함

		char charArr[] = str.toCharArray();
		Arrays.sort(charArr);	// 숫자 하나하나 잘라서 오름차순 정렬

		// 정렬이니까.. 맨 끝 원소부터 돌면서 더해줌
		for(int i = charArr.length - 1; i >= 0; i--) {
			int num = charArr[i] - '0';
			sum += num;
			sb.append(num);
		}
				
		// 30 배수가 되려면 합이 3으로 나눠 떨어져야 한다는 의미니까
        // 만약 3의 배수가 아니라면 -1
		if(charArr[0] != '0' || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sb.toString());
    }
}