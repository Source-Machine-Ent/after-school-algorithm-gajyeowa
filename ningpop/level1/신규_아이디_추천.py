# 2022.08.10
# 풀이 시간: 29분 36초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

import re

def solution(new_id: str) -> str:
    modified_new_id = new_id
    
    modified_new_id = modified_new_id.lower()

    modified_new_id = re.sub('[^a-z0-9-_.]', '', modified_new_id)

    modified_new_id = re.sub('[.]+', '.', modified_new_id)

    modified_new_id = re.sub('^[.]|[.]$', '', modified_new_id)

    if modified_new_id == '':
        modified_new_id = 'a'

    if len(modified_new_id) >= 16:
        modified_new_id = modified_new_id[:15]
        if modified_new_id[-1] == '.':
            modified_new_id = modified_new_id[:-1]
    
    if len(modified_new_id) <= 2:
        last_char = modified_new_id[-1]
        while len(modified_new_id) < 3:
            modified_new_id += last_char

    answer = modified_new_id
    return answer

print(solution("...!@BaT#*..y.abcdefghijklm")) # "bat.y.abcdefghi"
print(solution("z-+.^.")) # "z--"
print(solution("=.=")) # "aaa"
print(solution("123_.def")) # "123_.def"
print(solution("abcdefghijklmn.p")) # "abcdefghijklmn"