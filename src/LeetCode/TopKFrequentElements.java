package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
}
//https://leetcode.com/problems/top-k-frequent-elements/
class Solution347 {// 720 ms
    HashMap<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map=new HashMap<>();
        int[] result = new int[k];
        int n=nums.length;

        outer:
        for (int num : nums) {
            Integer b = map.get(num);
            map.put(num, b == null ? b = 1 : ++b);
            int index = -1, j, min = Integer.MAX_VALUE;
            for (j = 0; j < k; j++) {
                Integer a = map.get(result[j]);
                if (a == null) {
                    result[j] = num;
                    continue outer;
                }
                if (result[j] == num) {
                    continue outer;
                }
                if (a < min) {
                    min = a;
                    index = j;
                }

            }
            if (index != -1 && b > min) {
                result[index] = num;
            }
        }
        return result;
    }
}

