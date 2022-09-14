import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while(len(scoville) > 1):
        first = heapq.heappop(scoville)
        
        if first >= K:
            break
        seconed = heapq.heappop(scoville)
        
        heapq.heappush(scoville, first + (seconed * 2))
        answer += 1
    if (heapq.heappop(scoville) < K):
        answer = -1
    
    return answer
