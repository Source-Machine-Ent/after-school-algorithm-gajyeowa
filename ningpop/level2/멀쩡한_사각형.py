# 2022.08.26
# 풀이 시간: 분 초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/62048

import math

def solution(w: int, h: int) -> int:
    inclination = abs(h / w)
    block = math.ceil(inclination) * w
    answer = w * h - block
    return answer

print(solution(8, 12)) # 80
print(solution(3, 4)) # 6