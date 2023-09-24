public class Yoon_pro47 {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<String>();
        int answer = 0;
        int hit = 1;
        int miss = 5;
        
        if (cacheSize == 0) 
            return cities.length * miss;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase(); 

            if (cache.contains(city)) {
                cache.remove(city);                
                cache.add(city);
                answer += 1;
            } else { 
                if (cache.size() == cacheSize) {     
                    cache.remove(0);
                }
                                 
                cache.add(city);                   
                answer += 5;
            }
        }
        
        return answer;
    }
}
