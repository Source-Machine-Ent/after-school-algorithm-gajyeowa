# 2022.09.12
# 풀이 시간: 48분 03초
# 채점 결과: 오답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586

def solution(progresses: list, speeds: list) -> list:
    days = []
    for progress, speed in zip(progresses, speeds):
        remain = 100 - progress
        day = 0
        if remain % speed == 0:
            day = remain // speed
        else:
            day = remain // speed + 1
        days.append(day)

    answer = []
    increased_day = days[0]
    num = 1
    for day in days[1:]:
        if day - increased_day > 0:
            answer.append(num)
            num = 1
            increased_day += day
        else:
            num += 1
    answer.append(num)
    
    return answer

print(solution([93, 30, 55], [1, 30, 5])) # [2, 1]
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1])) # [1, 3, 2]
print(solution([1, 1, 50], [100, 2, 1])) # [1, 2]