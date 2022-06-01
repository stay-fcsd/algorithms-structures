package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode {



    public static void main(String[] args) {
        int[] nums = {-1, -1};
        int[] top = topKFrequent(nums, 1);

        for (int value : top) System.out.println(value);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
//        int max = Integer.MIN_VALUE;

//        for (int value : nums) max = Integer.max(value, max);

        for (int value : nums) {
            map.merge(value, 1, (oldVal, newVal) -> oldVal + newVal);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int bucket = (int) Math.floor(nums.length * entry.getValue() / max);
            int bucket = entry.getValue();
            if (buckets[bucket] == null) {
                buckets[bucket] = new ArrayList<>();
            }
            buckets[bucket].add(entry.getKey());
        }

        int[] result = new int[k];

        for (int i = buckets.length - 1; i >= 0 && k >= 0; i--) {
            if (buckets[i] != null) {
                for (int value : buckets[i]) {
                    if (!(k - 1 >= 0)) break;
                    result[--k] = value;
                }
            }
        }

        return result;

//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            min = Integer.min(entry.getValue(), min);
//            max = Integer.max(entry.getValue(), max);
//        }
//
//        List<Integer>[] countArr = new ArrayList[max - min + 1];
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (countArr[entry.getValue() - min] == null) {
//                countArr[entry.getValue() - min] = new ArrayList<>();
//            }
//            countArr[entry.getValue() - min].add(entry.getKey());
//        }
//
//        int arrIndex = 0;
//        int[] result = new int[k];
//
//        for (int i = countArr.length -1; i > 0; i--) {
//            if (arrIndex >= k) break;
//            if (countArr[i] != null) {
//                for (int value : countArr[i]) {
//                    result[arrIndex++] = value;
//                }
//            }
//        }
//
//
//        // k = 8, that means that all values are in the range 1 - 8.

    }
}
