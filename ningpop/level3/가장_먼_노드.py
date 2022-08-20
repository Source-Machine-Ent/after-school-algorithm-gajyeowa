# 2022.08.20
# 풀이 시간: 23분 45초
# 채점 결과: 정답
# 시간복잡도: O(NlogM)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189

import heapq

INF = int(1e9)

def dijkstra(start: int, graph: list, distance: list):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    

def solution(n: int, edge: list) -> int:

    graph = [[] for i in range(n + 1)]
    distance = [INF] * (n + 1)

    for a, b in edge:
        graph[a].append((b, 1))
        graph[b].append((a, 1))
    
    dijkstra(1, graph, distance)
    
    result = [ i for i in distance[2:] if i != 1e9 ]
    maximum = max(result)
    answer = result.count(maximum)

    return answer

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])) # 3