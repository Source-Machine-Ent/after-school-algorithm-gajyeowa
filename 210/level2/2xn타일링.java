package level2;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 4;
        Solution sol = new Solution();

        System.out.println("result : " + sol.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }
        
        return arr[n-1];
    }
}
