import java.io.IOException;
import java.util.Scanner;

public class Yoon_1100 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char chess[][] = new char[8][8];
		
		int count = 0;
		
		for (int i = 0; i < chess.length; i++) {
			String s = sc.next();

			for (int j = 0; j < chess.length; j++) {
				chess[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {     //짝행 짝열
					if (chess[i][j] == 'F')
						count++;
				}

				if (i % 2 != 0 && j % 2 != 0) {     //홀행 홀열
					if (chess[i][j] == 'F')
						count++;
				}
			}
		}

		System.out.println(count);
		sc.close();
	}
}
