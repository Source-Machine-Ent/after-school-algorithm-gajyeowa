# 2022.09.17
# 풀이 시간: 17분 00초
# 채점 결과: 오답
# 시간복잡도: O(NlogN)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42627

import heapq

def solution(jobs: list) -> int:
    h = []
    for value in jobs:
        heapq.heappush(h, (value[1] - value[0], value))
    
    print(h)

    answer = 0
    last_process_time = 0
    while h:
        job = heapq.heappop(h)
        req_to_res = job[1][1] - job[1][0] + last_process_time
        answer += req_to_res
        last_process_time += req_to_res
    answer //= len(jobs)
    return answer

print(solution([[0, 3], [1, 9], [2, 6]])) # 9