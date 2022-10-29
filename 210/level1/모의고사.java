// 20221029

package level1;

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] answers = {1,2,3,4,5};

        Solution sol = new Solution();
        System.out.println("result : " + sol.solution(answers));
    }
}

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {2,1,2,3,2,4,2,5};
		int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

        int maxVal = Integer.MIN_VALUE;
        int length = answers.length;
		for(int i=0; i<length; i++) {
			if(answers[i] == arr1[ i % arr1.length ]) cnt1++;
			if(answers[i] == arr2[ i % arr2.length ]) cnt2++;
			if(answers[i] == arr3[ i % arr3.length ]) cnt3++;
		}

		maxVal = Math.max(cnt1, cnt2);
		maxVal = Math.max(maxVal, cnt3);

		List<Integer> list = new ArrayList<Integer>();
		if(maxVal == cnt1) list.add(1);
		if(maxVal == cnt2) list.add(2);
        if (maxVal == cnt3) list.add(3);

		return list;
    }
}
