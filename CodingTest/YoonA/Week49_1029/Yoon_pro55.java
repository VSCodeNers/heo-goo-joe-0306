public class Yoon_pro55 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();    
        
        for(int i = 0; i < speeds.length; i++){
            q.offer((100 - progresses[i]) / speeds[i] + 
                ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1));
        }
           
        int cnt = 1;         
        int now = q.poll();        
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int next = q.poll();  
            
            if (now >= next) {
                cnt++;            
            } else {          
                arr.add(cnt);      
                now = next;       
                cnt = 1;           
            }
        }
        arr.add(cnt);      

        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}
