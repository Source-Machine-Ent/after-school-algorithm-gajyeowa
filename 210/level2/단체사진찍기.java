// 20220817 :: 메모리 효율 더 고민해보기

package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(n, data));
    }
}

class Solution {
    String[] data;
    int answer = 0;

    public int solution(int n, String[] data0) {
        data = data0;
        ArrayList<Character> peoples = new ArrayList<>(Arrays.asList('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'));
        dfs(0, peoples, peoples);

        return answer;
    }

    void dfs(int degree, ArrayList<Character> currArr, ArrayList<Character> leftPeoples) {
        if (degree == 8) {
            for (String s : data) {
                char a = s.charAt(0);
                char b = s.charAt(2);
                int res = s.charAt(4) - 48;

                if (s.charAt(3) == '=' && Math.abs(currArr.indexOf(a) - currArr.indexOf(b)) - 1 == res) {
                    answer++;
                }

                else if (s.charAt(3) == '>' && Math.abs(currArr.indexOf(a) - currArr.indexOf(b)) - 1 >= res) {
                    answer++;
                }

                else if (s.charAt(3) == '<' && Math.abs(currArr.indexOf(a) - currArr.indexOf(b)) - 1 <= res) {
                    answer++;
                }
            }
        }

        else {
            for (Character c : leftPeoples) {
                ArrayList<Character> nextPeople = new ArrayList<>();
                nextPeople.addAll(leftPeoples);
                nextPeople.remove(c);
                currArr.set(degree, c);
                ArrayList<Character> nextArr = new ArrayList<>();
                nextArr.addAll(currArr);

                dfs(degree + 1, nextArr, nextPeople);
            }
        }
    }
}