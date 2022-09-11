# 2022.09.11
# 풀이 시간: 63분 32초
# 채점 결과: 오답 -> 정답
# 시간복잡도: O(logN)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12899

INF = 1e9

def solution(n: int) -> int:
    answer_list = []
    remain_value = INF
    target_value = n
    while target_value > 0:
        if target_value % 3 == 0:
            target_value -= 1
            answer_list.append(4)
            target_value //= 3
        else:
            answer_list.append(target_value % 3)
            target_value //= 3
    
    answer_list = [ str(num) for num in answer_list ][::-1]

    answer = ''.join(answer_list)
    return answer

print(solution(1)) # 1
print(solution(2)) # 2
print(solution(3)) # 4
print(solution(4)) # 11
print(solution(157)) # 12211
print(solution(10)) # 41
print(solution(19)) # 141
print(solution(513)) # 124224