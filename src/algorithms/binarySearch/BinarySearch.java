package algorithms.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 8, 9};

        boolean found = binarySearch(arr, 5, 0, arr.length - 1);

        System.out.println(found);
    }

    public static boolean binarySearch(int[] arr, int value, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // if found at mid, return
            if (arr[mid] == value) return true;

            // search left half
            if (arr[mid] > value) return binarySearch(arr, value, low, mid - 1);

            // search right half
            if (arr[mid] < value) return binarySearch(arr, value, mid + 1, high);
        }
        return false;
    }
}
