package week5_0507;
import java.util.Scanner;
import java.util.Arrays;


public class N11399 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i= sc.nextInt(); //�ο���
		
		int[] arr=new int[i]; //����ð�
		
		for(int p=0; p<i; p++) {
			arr[p]=sc.nextInt(); //����ð� �迭�� �Է�
		}
		Arrays.sort(arr);
		
		int acc=0; //�����ð�
		int sum=0; //�ð��� �հ�
		
		for(int p=0; p<i; p++)
		{
			acc+=arr[p];
			sum+=acc;
		}
		
		System.out.println(sum);		
	}

}
