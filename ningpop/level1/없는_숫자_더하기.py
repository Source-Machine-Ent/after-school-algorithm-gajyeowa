# 2022.09.11
# 풀이 시간: 4분 39초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86051

def solution(numbers: list) -> int:
    table = [0] * 10
    for i in numbers:
        table[i] += 1
    answer = 0
    for i in range(len(table)):
        if table[i] == 0:
            answer += i
    return answer

print(solution([1,2,3,4,6,7,8,0])) # 14
print(solution([5,8,4,0,6,7,9])) # 6