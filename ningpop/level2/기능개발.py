# 2022.09.12
# 풀이 시간: 24분 35초
# 채점 결과: 오답
# 시간복잡도: O(NlogN)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586

import math

def solution(progresses: list, speeds: list) -> list:
    completed_days = []
    for i in range(len(progresses)):
        day = math.ceil((100 - progresses[i]) / speeds[i])
        completed_days.append(day)

    completed_days = completed_days[::-1]
    answer = []
    while completed_days:
        count = 1
        completed = completed_days.pop()
        if not completed_days:
            answer.append(count)
            break
        while completed >= completed_days[-1]:
            completed = completed_days.pop()
            count += 1
            if not completed_days:
                break
        
        answer.append(count)

    return answer

print(solution([93, 30, 55], [1, 30, 5])) # [2, 1]
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1])) # [1, 3, 2]