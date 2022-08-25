import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer;
        HashMap<String, Integer> checkScore = new HashMap<String, Integer>();
        checkScore.put("RT", 0);
        checkScore.put("TR", 0);
        checkScore.put("FC", 0);
        checkScore.put("CF", 0);
        checkScore.put("MJ", 0);
        checkScore.put("JM", 0);
        checkScore.put("AN", 0);
        checkScore.put("NA", 0);
        
        for(int i = 0; i < survey.length; i++) {
            int preScore = checkScore.get(survey[i]);
            checkScore.replace(survey[i], preScore + (choices[i] - 4));
        }
        
        int RT = checkScore.get("RT") - checkScore.get("TR");
        int FC = checkScore.get("FC") - checkScore.get("CF");
        int MJ = checkScore.get("MJ") - checkScore.get("JM");
        int AN = checkScore.get("AN") - checkScore.get("NA");
        
        String RT_result = (RT <= 0) ? "R" : "T";
        String FC_result = (FC < 0) ? "F" : "C";
        String MJ_result = (MJ < 0) ? "M" : "J";
        String AN_result = (AN <= 0) ? "A" : "N";
        
        answer = RT_result + FC_result + MJ_result + AN_result;
        
        return answer;
    }
}