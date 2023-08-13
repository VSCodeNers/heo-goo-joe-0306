import java.util.Scanner;

public class Min_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double arr[] = new double[n];

        double max = 0;
        double sum = 0;
        double avg = 0;

        for (int i=0; i<arr.length; i++){
            arr[i] = sc.nextDouble();
            if(arr[i]>max) {
               max = arr[i];
            }   

        }
        for (int i=0; i<arr.length; i++){
            arr[i] =  (arr[i]/max)*100;
            sum += arr[i];
        }
        sc.close();

        avg = sum/n;

        System.out.println(avg);

    }
		
}
