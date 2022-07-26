# 2022.07.26
# 풀이 시간: 31분 36초
# 채점 결과: 오답 -> 정답
# 시간복잡도: O(N^2)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92334

def solution(id_list: list, report: list, k: int) -> list:
    report_dict = {}

    for value in report:
        from_user, to_user = value.split()

        if from_user in report_dict.keys():
            if to_user not in report_dict[from_user]:
                report_dict[from_user].append(to_user)
        else:
            report_dict[from_user] = [to_user]

    user_status = {}
    for received in report_dict.values():
        for user in received:
            if user in user_status.keys():
                user_status[user] += 1
            else:
                user_status[user] = 1
    
    result = []
    for user in id_list:
        value = 0
        if user not in report_dict.keys():
            result.append(value)
            continue
        for u in report_dict[user]:
            if user_status[u] >= k:
                value += 1
        result.append(value)

    return result


print(solution(
    ["muzi", "frodo", "apeach", "neo"],
    ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],
    2
)) # [2, 1, 1, 0]
print(solution(
    ["con", "ryan"],
    ["ryan con", "ryan con", "ryan con", "ryan con"],
    3
)) # [0, 0]