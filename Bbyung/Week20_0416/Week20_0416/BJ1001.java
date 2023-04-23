import java.util.Scanner;

public class BJ1001{ 
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in); 

    int a, b; 
    int sum;

    System.out.print("A = ");
    a = sc.nextInt(); 
    System.out.print("B = ");
    b = sc.nextInt(); 

    System.out.println(a - b); 
    
    sc.close();
    } 
}