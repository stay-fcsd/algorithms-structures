package algorithms;

public class CountSort {

    /*
    Time Complexity
    Best	O(n+k)
    Worst	O(n+k)
    Average	O(n+k)
    Space Complexity	O(max)
    Stability	Yes

    Counting sort is used when:
        there are smaller integers with multiple counts.
        linear complexity is the need.
     */

    public static void main(String[] args) {
        int[] arr = {3,2, 2, 1, 4, -1, -2};

        sort(arr);

        for (int value : arr) System.out.println(value);
    }
    public static void sort(int[] arr) {
        // find min and max values of the array
        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            if (value < min) min = value;
        }

        for (int value : arr) {
            if (value > max) max = value;
        }

        // create count array that will be equal in size to the number of unique arr values
        int[] countArr = new int[max - min + 1];

        // map number of occurances of values from arr to count arr.
        for (int value : arr) countArr[value - min]++;

        // map values back from countArr to arr
        int arrIndex = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[arrIndex] = i + min;
                arrIndex++;
                countArr[i]--;
            }

        }
    }

}
