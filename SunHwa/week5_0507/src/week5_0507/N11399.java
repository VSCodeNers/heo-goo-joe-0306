package week5_0507;
import java.util.Scanner;
import java.util.Arrays;


public class N11399 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i= sc.nextInt(); //인원수
		
		int[] arr=new int[i]; //인출시간
		
		for(int p=0; p<i; p++) {
			arr[p]=sc.nextInt(); //인출시간 배열에 입력
		}
		Arrays.sort(arr);
		
		int acc=0; //누적시간
		int sum=0; //시간의 합계
		
		for(int p=0; p<i; p++)
		{
			acc+=arr[p];
			sum+=acc;
		}
		
		System.out.println(sum);		
	}

}
