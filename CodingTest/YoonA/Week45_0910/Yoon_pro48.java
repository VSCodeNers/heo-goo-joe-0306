public class Yoon_pro48 {
    public String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "(None)";
        int maxTime = 0;
        
        m = changeMelody(m);
 
        for (int i = 0; i < musicinfos.length; i++) {
            String[] mugicinfo = musicinfos[i].split(",");
            
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1 = format.parse(mugicinfo[0]);
            Date date2 = format.parse(mugicinfo[1]);
            
            int timeDiff = (int) (date2.getTime() - date1.getTime()) / (60 * 1000); // 시간차를 분으로 바꿈
            StringBuilder sb = new StringBuilder();
 
            String music = changeMelody(mugicinfo[3]);
            // 해당 시간동안 재생된 멜로디를 저장
            for (int j = 0; j < timeDiff; j++) {
                sb.append(music.charAt(j % music.length()));
            }
            music = sb.toString();
 
            // 멜로디가 발견 되었을 때, 기존 멜로디 최대 길이(maxTime)보다 더 길 경우에만 저장
            if (music.contains(m) && maxTime < timeDiff) {
                maxTime = timeDiff;
                answer = mugicinfo[2];
            }
        }
        
        return answer;
    }
    
    public static String changeMelody(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");   
        
        return melody;
    }
}