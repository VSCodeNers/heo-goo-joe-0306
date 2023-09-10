import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoon_BJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

		String num = "";
		int result = 0;
		boolean check = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != '-' && str.charAt(i) != '+') {
				num += str.charAt(i);
			}

            // -, +가 나왔거나 마지막 값까지 입력 되었을 때
			if(str.charAt(i) == '-' || str.charAt(i) == '+' || i == str.length() - 1) {
				//check가 false면 더하기 해주고 true면 빼기를 해줌
				if(!check) {
					result += Integer.parseInt(num);
				}else {
					result -= Integer.parseInt(num);
				}
				//num을 연산해줬으면 초기화
				num = "";
			}

			if (str.charAt(i) == '-') check = true;
		}
		System.out.println(result);
    }
}
