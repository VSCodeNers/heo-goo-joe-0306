import java.util.Scanner;
public class Min_9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
        	String input = sc.next();
        	
        	String first = String.valueOf(input.charAt(0));
        	String end = String.valueOf(input.charAt(input.length()-1));
        	
        	System.out.println(first + end);
        
        }
    }
    


}