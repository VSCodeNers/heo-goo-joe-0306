// 프로그래머스 - 모의고사(Lv.1)

import java.lang.Math;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 1, 2, 4, 5};
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i%5]) score[0]++;   // 1번이 맞힘
            if(answers[i] == second[i%8]) score[1]++;  // 2번이 맞힘
            if(answers[i] == third[i%10/2]) score[2]++; // 3번이 맞힘
        }
        
        //System.out.print(score[0] + " " + score[1] + " " + score[2]);
        int maxScore = Math.max(score[0] , Math.max(score[1] , score[2]));
        
        for(int i = 0; i < 3; i++) {
            if(score[i] == maxScore) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}