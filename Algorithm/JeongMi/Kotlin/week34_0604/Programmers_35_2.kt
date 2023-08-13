// 프로그래머스 - 최댓값과 최솟값(Lv.2)
class Solution {
    fun solution(s: String): String {
        // 공백 기준으로 문자열 자르기
        val numberStr = s.split("\\s".toRegex()).toTypedArray()
        
        // String -> int
        val numbers = mutableListOf<Int>()
        for(num: String in numberStr) {
            numbers.add(num.toInt())
        }
        
        // 오름차순 정렬
        numbers.sort()
        
        // 최솟값: 0번 방에 있는 값
        // 최댓값: 마지막 인덱스에 있는 값
        var answer = numbers[0].toString() + " " + numbers[numbers.size - 1].toString()
        
        return answer
    }
}