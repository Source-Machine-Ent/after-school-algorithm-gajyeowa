package level2;

class Main {
    public static void main(String[] args) throws Exception {
        String[][] p = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(p)[0] + " " + sol.solution(p)[1]);
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] board = { places[i][0].toCharArray(), places[i][1].toCharArray(), places[i][2].toCharArray(),
                    places[i][3].toCharArray(), places[i][4].toCharArray() };

            answer[i] = 1;
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (flag) break;
                for (int k = 0; k < 5; k++) {
                    if (board[j][k] == 'P' && dfs(board, 0, j, k, j, k, 'P') == 0) {
                        answer[i] = 0;
                        flag = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public int dfs(char[][] board, int depth, int i, int j, int pi, int pj, char prev) {
        char currChar = '.';
        if (i >= 0 && i < 5 && j >= 0 && j < 5)
            currChar = board[i][j];

        //System.out.println(depth + " p:" + pi + "-" + pj + " " + prev + "        " + currChar + " " + i + "-" + j+ " ");
        if (depth == 1 && currChar == 'P')
            return 0;
        if (depth == 2) {
            if (i != pi && j != pj && currChar == 'O' && prev == 'P') return 0;
            else return 1;
        }

        if (dfs(board, depth + 1, i, j + 1, pi, pj, currChar) == 0) {  return 0; }
        else if (dfs(board, depth + 1, i, j - 1, pi, pj, currChar) == 0) {  return 0; }
        else if (dfs(board, depth + 1, i + 1, j, pi, pj, currChar) == 0) {  return 0; }
        else if (dfs(board, depth + 1, i - 1, j, pi, pj, currChar) == 0) {  return 0; }
        else return 1;
    }
}