# 2022.08.01
# 풀이 시간: 8분 58초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/77484

def solution(lottos: list, win_nums: list) -> list:
    max_count = 0
    min_count = 0
    for num in lottos:
        if num == 0:
            max_count += 1
        else:
            if num in win_nums:
                max_count += 1
                min_count += 1

    lottos_result = { 6: 1, 5: 2, 4: 3, 3: 4, 2: 5, 1: 6, 0: 6 }
    answer = [lottos_result[max_count], lottos_result[min_count]]
    return answer

print(solution(
    [44, 1, 0, 0, 31, 25],
    [31, 10, 45, 1, 6, 19]
)) # [3, 5]
print(solution(
    [0, 0, 0, 0, 0, 0],
    [38, 19, 20, 40, 15, 25]
)) # [1, 6]
print(solution(
    [45, 4, 35, 20, 3, 9],
    [20, 9, 3, 45, 4, 35]
)) # [1, 1]