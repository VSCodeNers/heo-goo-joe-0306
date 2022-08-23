public class Yoon_pro8 {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i])
                absolutes[i] = absolutes[i]; 
            else
                absolutes[i] -= absolutes[i] * 2;  
        
            sum += absolutes[i];
        }
        
        return sum;
    }
}
