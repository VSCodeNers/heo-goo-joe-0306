import java.util.Scanner;

public class Yoon_1546 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		double sum = 0, avg = 0, M = 0;
		double arr[] = new double [N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextDouble();
			
			if (arr[i] > M)
				M = arr[i];
			
			sum += arr[i];
		}
		avg = (sum / M * 100) / 3;

		System.out.print(avg);
	}
}
