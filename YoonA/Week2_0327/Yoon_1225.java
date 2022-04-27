import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yoon_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		String a = str.nextToken();
		String b = str.nextToken();
		
        int sum = 0;
        
        for (int i = 0; i < a.length(); i++) {
        	for (int j = 0; j < b.length(); j++) {
        		sum += (a.charAt(i)-'0') * (b.charAt(j)-'0');   //char -> int
        	}
        }
        System.out.println(sum);
        br.close();
	}
}
