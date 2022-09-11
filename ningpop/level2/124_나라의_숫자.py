# 2022.09.11
# 풀이 시간: 분 초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12899

INF = 1e9

def rounding(num: int) -> int:
    if num == 0:
        return 4
    elif num == 1:
        return -1
    elif num == 2:
        return 1
    elif num == 4:
        return 2

def solution(n: int) -> int:
    answer_list = []
    remain_value = INF
    target_value = n
    while target_value > 0:
        remain_value = target_value % 3
        target_value //= 3
        answer_list.append(remain_value)
    
    answer_list = answer_list[::-1]
    for i in range(len(answer_list)):
        if answer_list[i] == 0:
            answer_list[i] = rounding(answer_list[i])
            answer_list[i - 1] = rounding(answer_list[i - 1])
    answer = [ str(num) for num in answer_list if num != -1 ]

    return int(''.join(answer))

print(solution(1)) # 1
print(solution(2)) # 2
print(solution(3)) # 4
print(solution(4)) # 11
print(solution(157)) # 12211
print(solution(10))
print(solution(19)) # 
print(solution(513)) # 124224