public class Yoon_pro51 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for (String pn : phone_book) {
            set.add(pn);
        }
        
        for (String pn : phone_book) {
            for (int i = 1; i < pn.length(); i++) {
                if (set.contains(pn.substring(0, i))) return false;
            }    
        }
        
        return true;
    }
}
