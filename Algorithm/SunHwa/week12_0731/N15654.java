package week12_0731;

import java.util.Scanner;
import java.util.Arrays;

public class N15654 {
	static int N,M;
	static int[] num, arr;
	static StringBuilder st = new StringBuilder();
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num=new int[N];
		arr = new int[N];
		isvisited = new boolean[N];
		for(int i=0; i<N ; i++) {
			num[i] = sc.nextInt();
		}
 		Arrays.sort(num); //Á¤·Ä
 		dfs(0);
 		System.out.println(st.toString());
	}	
 		private static void dfs(int count) {
 	        if (count == M) {
 	            for (int i = 0; i < M; i++) {
 	                st.append(arr[i]).append(" ");
 	            }
 	            st.append("\n");
 	            return;
 	        }
 	        for (int i = 0; i < N; i++) {
 	            if (!isvisited[i]) {
 	                isvisited[i] = true;
 	                arr[count] = num[i];
 	                dfs(count + 1);
 	                isvisited[i] = false;
 	            }
 	        }
	} 
	
}
