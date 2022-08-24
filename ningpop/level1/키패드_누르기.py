# 2022.08.24
# 풀이 시간: 19분 39초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256

def solution(numbers: list, hand: str) -> str:
    finger_location = { 1: (0, 0), 2: (0, 1), 3: (0, 2),
                        4: (1, 0), 5: (1, 1), 6: (1, 2),
                        7: (2, 0), 8: (2, 1), 9: (2, 2),
                        '*': (3, 0), 0: (3, 1), '#': (3, 2)}
    
    cur_left = finger_location['*']
    cur_right = finger_location['#']

    answer = ''
    for num in numbers:
        which_hand: str
        if num in (1, 4, 7):
            which_hand = 'left'
        elif num in (3, 6, 9):
            which_hand = 'right'
        else: # 2, 5, 8, 0
            left_d = abs(cur_left[0] - finger_location[num][0]) + abs(cur_left[1] - finger_location[num][1])
            right_d = abs(cur_right[0] - finger_location[num][0]) + abs(cur_right[1] - finger_location[num][1])
            if left_d < right_d:
                which_hand = 'left'
            elif left_d > right_d:
                which_hand = 'right'
            else:
                if hand == 'left':
                    which_hand = 'left'
                elif hand == 'right':
                    which_hand = 'right'

        if which_hand == 'left':
            cur_left = finger_location[num]
            answer += 'L'
        elif which_hand == 'right':
            cur_right = finger_location[num]
            answer += 'R'

    return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right")) # "LRLLLRLLRRL"
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left")) # "LRLLRRLLLRR"
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right")) # "LLRLLRLLRL"