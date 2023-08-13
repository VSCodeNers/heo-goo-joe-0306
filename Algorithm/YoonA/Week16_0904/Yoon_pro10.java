import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int value = 10;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                stack.push(arr[i]);
                value = arr[i];
            }
        }
        return stack;
    }
}