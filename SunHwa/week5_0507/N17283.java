package week5_0507;
import java.util.Scanner;


public class N17283 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int L= sc.nextInt();
		int R=sc.nextInt();
		int sum=0;
		int n=1; //�ŵ�������
		
		while(L>5 && L<10001) {
				if(n!=1)
					sum+=n*L;		
				n*=2;
				L=L*R/100;
		}
		System.out.println(sum);
	}

}
