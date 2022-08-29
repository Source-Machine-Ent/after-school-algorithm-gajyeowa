# 2022.08.26
# 풀이 시간: 48분 28초
# 채점 결과: 오답 -> 정답
# 시간복잡도: O(1)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/62048

import math

def solution(w: int, h: int) -> int:
    gcd_num = math.gcd(w, h)
    w_prime = w // gcd_num
    h_prime = h // gcd_num
    answer = w * h - ((w_prime + h_prime - 1) * gcd_num)
    return answer

print(solution(8, 12)) # 80
print(solution(3, 4)) # 6
print(solution(3, 5)) # 8