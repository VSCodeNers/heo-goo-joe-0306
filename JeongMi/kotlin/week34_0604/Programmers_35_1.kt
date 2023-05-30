// 프로그래머스 - 멀리 뛰기(Lv.2)
// 1칸 이동 - 1칸 전에서 오는 경우
// 2칸 이동 - 2칸 전에서 오는 경우
class Solution {
    var dp: MutableList<Long> = mutableListOf<Long>()
    fun solution(n: Int): Long {
        // 맨 끝 칸에 도달하는 방법의 가짓수
        var answer: Long = 0
        
        dp.add(0) // 0칸
        dp.add(1) // 1칸
        dp.add(2) // 2칸
        
        answer = longJump(n)
        
        return answer
    }
    // 멀리 뛰기
    fun longJump(pre: Int): Long {
        // 아직 pre칸 계산이 안 된 경우
        if(dp.size <= pre) {
            // 한 칸 전, 두 칸 전의 방법 수를 합친다
            dp.add((longJump(pre - 1) + longJump(pre - 2)) % 1234567)
        }

        return dp[pre]
    }
}