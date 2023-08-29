import java.util.Scanner;

public class Min_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[26];

        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
        String input = sc.next();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(arr[ch - 'a'] == -1){
                arr[ch -'a'] = i;
                
            }
        }
        for(int val:arr){
            System.out.println(val + " ");
        }

    }
}
