# 2022.08.04
# 풀이 시간: 21분 42초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42888

def solution(record: list) -> list:
    user_table = {}
    result = []
    for data in record:
        splited_data = list(data.split())
        order = splited_data[0]
        uid = splited_data[1]

        if order == 'Enter':
            nickname = splited_data[2]
            user_table[uid] = nickname
            result.append(('Enter', uid))
        elif order == 'Leave':
            nickname = user_table[uid]
            result.append(('Leave', uid))
        elif order == 'Change':
            nickname = splited_data[2]
            user_table[uid] = nickname

    answer = []
    for data in result:
        order, uid = data[0], data[1]

        if order == 'Enter':
            answer.append(f'{user_table[uid]}님이 들어왔습니다.')
        elif order == 'Leave':
            answer.append(f'{user_table[uid]}님이 나갔습니다.')
    
    return answer

print(solution(
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
)) # ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]