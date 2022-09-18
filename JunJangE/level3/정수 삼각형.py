def solution(triangle):
    answer = 0
    for i in range(len(triangle)):
        triangle[i].append(0)
    
    for j in range(1, len(triangle)):
        for k in range(len(triangle[j]) - 1):
            triangle[j][k] += max(triangle[j-1][k], triangle[j-1][k-1])
    
    answer = max(triangle[-1])
    return answer
