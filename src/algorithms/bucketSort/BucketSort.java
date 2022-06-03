package algorithms.bucketSort;

/*
    it is important to have as many buckets as elements because
    we want on average to each bucket have one element or as
    least as possible
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 2, 10, 8, 7};

        bucketSort(arr);

        for (int value : arr) System.out.println(value);
    }

    public static void bucketSort(int[] arr) {
        List<Integer>[] buckets = new ArrayList[arr.length + 1];
        int max = Arrays.stream(arr).max().getAsInt();

        for (int i = 0; i < arr.length; i++) {
            int bucket = (int) Math.floor( arr.length * arr[i] / max);
           if (buckets[bucket] == null) buckets[bucket] = new ArrayList<>();
           buckets[bucket].add(arr[i]);
        }

        for (List<Integer> bucket : buckets) {
            if (bucket == null) continue;
            Collections.sort(bucket);
        };

        int outputIndex = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket == null) continue;
            for (int value : bucket) {
                arr[outputIndex++] = value;
            }
        }
    }
}
