# 2022.08.20
# 풀이 시간: 9분 30초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/81301

def solution(s: str) -> int:
    word_table = { 'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4',
                    'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9' }
    
    answer = ''
    token = ''
    for c in s:
        if c.isdigit():
            answer += c
            continue
        
        token += c
        if token in word_table.keys():
            answer += word_table[token]
            token = ''

    return int(answer)

print(solution("one4seveneight")) # 1478
print(solution("23four5six7")) # 234567
print(solution("2three45sixseven")) # 234567
print(solution("123")) # 123