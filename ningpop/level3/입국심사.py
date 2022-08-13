# 2022.08.13
# 풀이 시간: 37분 45초
# 채점 결과: 정답
# 시간복잡도: O(NlogN)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43238

def solution(n: int, times: list):
    start = 0
    longest_examiner = max(times)
    end = ((longest_examiner * n) + 1) // len(times)
    
    answer = 0
    while (start <= end):
        total = 0
        mid = (start + end) // 2
        for x in times:
            total += (mid // x)
        
        if total < n:
            start = mid + 1
        else:
            answer = mid
            end = mid - 1

    return answer

print(solution(6, [7, 10])) # 28