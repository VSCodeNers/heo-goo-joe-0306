// 백준 - 연산자 끼워넣기 (2)(15658)
import java.io.BufferedReader
import java.util.StringTokenizer

private var nums: MutableList<Int> = mutableListOf<Int>()
private var operators: MutableList<Int> = mutableListOf<Int>()
private var N: Int? = null
private var min: Int = 1000000000
private var max: Int = -1000000000
//
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
  N = readLine().toInt()
  
  // 숫자 입력
  var token = StringTokenizer(readLine())
  for(i: Int in 1..N) {
    nums.add(token.nextToken().toInt())
  }
  // 연산자 갯수 입력
  token = StringTokenizer(readLine())
  for(i: Int in 1..4) {
    operators.add(token.nextToken().toInt())
  }

  calculate(0, 0, 0, 0, 0, 0)

  print(max.toString() + "\n" + min.toString())
}

// 계산
private fun calculate(result: Int, index: Int, add: Int, sub: Int, mul: Int, div: Int) {
  if(index == N) {
    if(result > max) max = result
    if(result < min) min = result
    return
  }
  
  // 더하기
  if(add < operators[0]) {
    calculate(result + nums[index], index + 1, add + 1, sub, mul, div)
  }

  // 빼기
  if(sub < operators[1]) {
    calculate(result - nums[index], index + 1, add, sub + 1, mul, div)
  }

  // 곱하기
  if(mul < operators[2]) {
    calculate(result * nums[index], index + 1, add, sub, mul + 1, div)
  }

  // 나누기
  if(div < operators[3]) {
    calculate(result / nums[index], index + 1, add, sub, mul, div + 1)
  }
}