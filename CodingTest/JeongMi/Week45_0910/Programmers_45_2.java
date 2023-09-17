// 프로그래머스 - [3차] 방금그곡(Lv.2)
class Solution {
  public String solution(String m, String[] musicinfos) {
    String answer = "";
    int maxPlayTime = -1;
    
    // 찾아야할 멜로디에 들어있는 # 붙은 음을 치환
    m = changeMelody(m);
    
    for (String musicInfo : musicinfos) {
      // ,를 기준으로 자르기
      String[] info = musicInfo.split(",");
      // 노래 제목
      String title = info[2];
      // 악보 정보에 들어있는 # 붙은 음 치환
      String melodyInfo = changeMelody(info[3]);
      
      // 시작 시간
      String[] timeInfo = info[0].split(":");
      // 시작 시간 분단위로 변환
      int start = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
      
      // 종료 시간
      timeInfo = info[1].split(":");
      // 끝난 시간 분단위로 변환
      int end = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
      
      // 해당 음악의 재생 시간
      int play = end - start;
      
      // 음악의 길이보다 재생 시간이 길 때
      if (play > melodyInfo.length()) {
        StringBuilder newMelody = new StringBuilder();
        
        // 나눈 몫 만큼 악보 처음부터 반복
        for (int i = 0; i < play / melodyInfo.length(); i++)
          newMelody.append(melodyInfo);
        
        // 나머지만큼 악보에서 잘라서 붙임
        newMelody.append(melodyInfo.substring(0, play % melodyInfo.length()));
        melodyInfo = newMelody.toString();
      } else {
        // 재생 시간 만큼만 재생
        melodyInfo = melodyInfo.substring(0, play);
      }
        
      // 조건에 일치하는 음악 반환
      // 조건이 일치하는 음악이 여러개면 재생된 시간이 제일 긴 음악 제목을 반환
      if (melodyInfo.contains(m) && play > maxPlayTime) {
        answer = title;
        maxPlayTime = play;
      }
        
    }
    
    // 플레이 시간이 -1이면 조건이 일치하는 음악이 없는 것이므로 (None)
    return maxPlayTime != -1 ? answer : "(None)";
  }
  
  // #붙은 음 치환
  static String changeMelody(String oldMelody) {
    oldMelody = oldMelody.replaceAll("C#", "c");
    oldMelody = oldMelody.replaceAll("D#", "d");
    oldMelody = oldMelody.replaceAll("F#", "f");
    oldMelody = oldMelody.replaceAll("G#", "g");
    String newMelody = oldMelody.replaceAll("A#", "a");
    
    return newMelody;
  }
}