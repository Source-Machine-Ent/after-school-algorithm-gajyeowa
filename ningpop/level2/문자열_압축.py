# 2022.07.27
# 풀이 시간: 35분 15초
# 채점 결과: 정답
# 시간복잡도: O(NlogN)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60057

def solution(s: list) -> int:
    max_size = len(s)

    result = s
    for i in range(1, max_size // 2 + 1):
        current_char = s[:i]
        count = 1
        compressed = ''
        for j in range(i, max_size, i):
            if current_char == s[j : j + i]:
                count += 1
            else:
                if count != 1:
                    compressed += f'{str(count)}{current_char}'
                else:
                    compressed += current_char
                current_char = s[j : j + i]
                count = 1
        if count != 1:
            compressed += f'{str(count)}{current_char}'
        else:
            compressed += current_char
        
        if len(compressed) < len(result):
            result = compressed
    
    return len(result)


print(solution("aabbaccc")) # 7 (2a2ba3c)
print(solution("ababcdcdababcdcd")) # 9 (2ababcdcd)
print(solution("abcabcdede")) # 8 (2abcdede)
print(solution("abcabcabcabcdededededede")) # 14 (2abcabc2dedede)
print(solution("xababcdcdababcdcd")) # 17 (xababcdcdababcdcd)