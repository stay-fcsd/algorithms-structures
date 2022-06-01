package algorithms;

import java.util.*;

public class BucketSort {

    /*

    Time Complexity
    Best	O(n+k)
    Worst	O(n2)
    Average	O(n)
    Space Complexity	O(n+k)
    Stability	Yes


    Bucket Sort Applications
    Bucket sort is used when:

    input is uniformly distributed over a range.
    there are floating point values
     */

    public static void main(String[] args) {
        int[] nums = {11, 9, 21, 8, 17, 19,};

        int numOfBuckets = (int) Math.sqrt(nums.length);

        bucketSort(nums);

        for (int value : nums) System.out.println(value);
    }

    public static void bucketSort(int[] arr) {

        List<Integer>[] buckets = new ArrayList[arr.length + 1];
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        // find max arr value
        for (int value : arr) max = Integer.max(value, max);

        // initialize each bucket with empty list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // values are mapped to indexes in a buckets array
        for (int i = 0; i < arr.length; i++) {
            // max value --> n * max / max --> n
            // max value will take bucket index n
            // therefore we need n + 1 buckets as defined above
            int bucket = (int) Math.floor(n * arr[i] / max);
            buckets[bucket].add(arr[i]);
        }

        // sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // add values back to original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

}
