// 20221011

package level1;

import java.util.HashSet;

class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = {3,3,3,2,2,4};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(nums));
    }
}


class Solution {
    public int solution(int[] nums) {
        int cnt = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums)
            set.add(n);

        if (cnt < set.size())
            return cnt;
        else return set.size();
    }
}