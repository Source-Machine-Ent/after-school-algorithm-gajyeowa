# 2022.08.30
# 풀이 시간: 27분 12초
# 채점 결과: 정답
# 시간복잡도: O(N^2)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64061

def bomb_doll(stack: list) -> bool:
    if (not stack) or len(stack) == 1:
        return False

    if stack[-1] == stack[-2]:
        stack.pop()
        stack.pop()
        return True


def solution(board: list, moves: list) -> int:
    stage = board
    size = len(stage)

    stack = []

    answer = 0
    for m in moves:
        j = m - 1
        i = 0
        while i < size:
            if stage[i][j] == 0:
                i += 1
                continue

            stack.append(stage[i][j])
            stage[i][j] = 0
            if bomb_doll(stack):
                answer += 2
            break
    return answer

print(solution([
        [0,0,0,0,0],
        [0,0,1,0,3],
        [0,2,5,0,1],
        [4,2,4,4,2],
        [3,5,1,3,1]
    ],
    [1,5,3,5,1,2,1,4]
)) # 4